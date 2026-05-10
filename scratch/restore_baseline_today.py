import json
import re
import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\0154e747-3b96-4462-ad1c-690925051cb3\.system_generated\logs\overview.txt"
with open(log_path, 'rb') as f:
    raw_data = f.read()

try:
    data = raw_data.decode('utf-16-le', errors='ignore')
except:
    data = raw_data.decode('utf-8', errors='ignore')

# Find the result of step_index 75 (which is usually the next JSON object in the log)
# Or just search for the first "Output":"<!DOCTYPE html>"
start_marker = '"Output":"<!DOCTYPE html>'
end_marker = '</html>"'

start_idx = data.find(start_marker)
if start_idx != -1:
    start_idx += len('"Output":"')
    end_idx = data.find(end_marker, start_idx)
    if end_idx != -1:
        end_idx += len('</html>')
        raw_html_escaped = data[start_idx:end_idx]
        # Unescape the HTML from the JSON string
        html = raw_html_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
        
        target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
        with open(target, 'w', encoding='utf-8') as f_out:
            f_out.write(html)
        print(f"SUCCESS: Restored baseline index.html ({len(html)} bytes)")
    else:
        print("FAILURE: end_marker not found")
else:
    print("FAILURE: start_marker not found")
