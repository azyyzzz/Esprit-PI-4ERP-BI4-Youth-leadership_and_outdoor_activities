import json
import re
import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\a863d7e3-62d0-40c2-ba7c-94e42ae45600\.system_generated\logs\overview.txt"
if not os.path.exists(log_path):
    print("FAILURE: Prev Log file not found")
    exit()

with open(log_path, 'r', encoding='utf-16le') as f:
    data = f.read()

# Find all write_to_file calls for index.html
# Pattern: "name":"write_to_file".*?"TargetFile":".*?index.html"
matches = list(re.finditer(r'\{"name":"write_to_file","args":\{.*?"TargetFile":".*?index\.html".*?\}', data, re.DOTALL))

if matches:
    last_match = matches[-1].group(0)
    # Parse the JSON inside the log entry
    # Note: The log entry itself is a JSON object with "tool_calls"
    # Actually, let's just find the "CodeContent" within this match.
    cc_match = re.search(r'"CodeContent":"(.*?)(?<!\\)"', last_match, re.DOTALL)
    if cc_match:
        raw_html_escaped = cc_match.group(1)
        html = raw_html_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
        
        target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
        with open(target, 'w', encoding='utf-8') as f_out:
            f_out.write(html)
        print(f"SUCCESS: Restored index.html from prev session ({len(html)} bytes)")
    else:
        print("FAILURE: CodeContent not found in last match")
else:
    print("FAILURE: No write_to_file for index.html found in prev session")
