import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\a863d7e3-62d0-40c2-ba7c-94e42ae45600\.system_generated\logs\overview.txt"
if not os.path.exists(log_path):
    print("FAILURE: Prev Log file not found")
    exit()

# Try reading as binary and decoding with errors='ignore'
with open(log_path, 'rb') as f:
    raw_data = f.read()

try:
    data = raw_data.decode('utf-16-le', errors='ignore')
except:
    data = raw_data.decode('utf-8', errors='ignore')

# Search for index.html writes
# We want the LAST one.
marker = '"TargetFile":"c:\\\\Users\\\\MSI\\\\Desktop\\\\wetransfer_scouts_2026-02-28_1339\\\\Scouts\\\\ml_app\\\\templates\\\\index.html"'
# Actually, the path might be escaped differently in the JSON
# Let's just search for index.html

indices = [i for i in range(len(data)) if data.startswith('index.html', i)]
if not indices:
    print("FAILURE: No index.html found")
    exit()

# Work backwards from the last index to find "CodeContent":"
last_idx = indices[-1]
cc_start = data.rfind('"CodeContent":"', 0, last_idx)
if cc_start != -1:
    cc_start += len('"CodeContent":"')
    # Find the end of the content (the first unescaped quote)
    # Actually, let's find <!DOCTYPE html> and </html>
    html_start = data.find('<!DOCTYPE html>', cc_start)
    html_end = data.find('</html>', html_start)
    if html_start != -1 and html_end != -1:
        html_end += len('</html>')
        raw_html_escaped = data[html_start:html_end]
        html = raw_html_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
        
        target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
        with open(target, 'w', encoding='utf-8') as f_out:
            f_out.write(html)
        print(f"SUCCESS: Restored index.html ({len(html)} bytes)")
    else:
        print("FAILURE: HTML tags not found")
else:
    print("FAILURE: CodeContent marker not found")
