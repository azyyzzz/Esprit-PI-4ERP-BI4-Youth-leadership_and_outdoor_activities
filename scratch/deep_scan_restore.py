import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\a863d7e3-62d0-40c2-ba7c-94e42ae45600\.system_generated\logs\overview.txt"
if not os.path.exists(log_path):
    print("FAILURE: Prev Log file not found")
    exit()

with open(log_path, 'rb') as f:
    raw_data = f.read()

# Try to decode or just scan bytes
# Pattern: <!DOCTYPE html> ... </html>
# We want the one that is NOT escaped (or is escaped but complete)
# Actually, let's find the last occurrence of "</html>" and work backwards.

def find_html(data_bytes):
    tag_end = b'</html>'
    tag_start = b'<!DOCTYPE html>'
    
    # Start from the end
    idx = data_bytes.rfind(tag_end)
    while idx != -1:
        # Find the nearest start before this end
        start_idx = data_bytes.rfind(tag_start, 0, idx)
        if start_idx != -1:
            html = data_bytes[start_idx : idx + len(tag_end)]
            # Check if this is part of a write_to_file call
            # Actually, just check the size. If it's > 10KB, it's likely our index.html
            if len(html) > 10000:
                return html
        idx = data_bytes.rfind(tag_end, 0, idx)
    return None

html_bytes = find_html(raw_data)
if html_bytes:
    # Handle escaping if it was inside a JSON string
    # We'll just try to decode it normally first
    try:
        html = html_bytes.decode('utf-8')
    except:
        # Try unescaping common JSON sequences
        html = html_bytes.decode('utf-8', errors='ignore').replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
    
    target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
    with open(target, 'w', encoding='utf-8') as f_out:
        f_out.write(html)
    print(f"SUCCESS: Restored HTML from previous session ({len(html)} bytes)")
else:
    print("FAILURE: No suitable HTML block found")
