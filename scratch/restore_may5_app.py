import json
import re
import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\51d8ba0b-d800-44a8-ab81-ea126cf41c2b\.system_generated\logs\overview.txt"
if not os.path.exists(log_path):
    print("FAILURE: May 5 Log file not found")
    exit()

with open(log_path, 'r', encoding='utf-16le') as f:
    data = f.read()

# Find all write_to_file calls for app.py
matches = list(re.finditer(r'\{"name":"write_to_file","args":\{.*?"TargetFile":".*?app\.py".*?\}', data, re.DOTALL))

if matches:
    last_match = matches[-1].group(0)
    cc_match = re.search(r'"CodeContent":"(.*?)(?<!\\)"', last_match, re.DOTALL)
    if cc_match:
        raw_code_escaped = cc_match.group(1)
        code = raw_code_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
        
        target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\app.py"
        with open(target, 'w', encoding='utf-8') as f_out:
            f_out.write(code)
        print(f"SUCCESS: Restored app.py from May 5 ({len(code)} bytes)")
    else:
        print("FAILURE: CodeContent not found")
else:
    print("FAILURE: No app.py found")
