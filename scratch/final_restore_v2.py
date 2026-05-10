import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\0154e747-3b96-4462-ad1c-690925051cb3\scratch\academic_v1_log.txt"
with open(log_path, 'r', encoding='utf-16le') as f:
    data = f.read()

# Search for the escaped HTML tags
start_str = "<!DOCTYPE html>"
end_str = "</html>"

# We need to find the escaped versions: \\n<!DOCTYPE html> ... </html>\\n
# Actually, the log uses \n for newlines in the JSON string.
start_idx = data.find("<!DOCTYPE html>")
end_idx = data.find("</html>")

if start_idx != -1 and end_idx != -1:
    # Adjust to include </html>
    end_idx += len("</html>")
    raw_html_escaped = data[start_idx:end_idx]
    
    # Unescape common characters
    html = raw_html_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
    
    target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
    with open(target, 'w', encoding='utf-8') as f_out:
        f_out.write(html)
    print(f"SUCCESS: Extracted {len(html)} bytes to index.html")
else:
    print(f"FAILURE: Start {start_idx}, End {end_idx}")
