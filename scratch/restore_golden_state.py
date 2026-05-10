import json
import re
import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\a863d7e3-62d0-40c2-ba7c-94e42ae45600\.system_generated\logs\overview.txt"
if not os.path.exists(log_path):
    print("FAILURE: Prev Log file not found")
    exit()

with open(log_path, 'rb') as f:
    raw_data = f.read()

try:
    data = raw_data.decode('utf-16-le', errors='ignore')
except:
    data = raw_data.decode('utf-8', errors='ignore')

def restore_file(filename, target_path):
    # Find all write_to_file calls for this filename
    # We use a pattern that handles escaped backslashes in JSON
    pattern = rf'\{{"name":"write_to_file","args":\{{.*?"TargetFile":".*?{filename}".*?\}}'
    matches = list(re.finditer(pattern, data, re.DOTALL))
    
    if matches:
        last_match = matches[-1].group(0)
        cc_match = re.search(r'"CodeContent":"(.*?)(?<!\\)"', last_match, re.DOTALL)
        if cc_match:
            raw_code_escaped = cc_match.group(1)
            code = raw_code_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
            
            with open(target_path, 'w', encoding='utf-8') as f_out:
                f_out.write(code)
            print(f"SUCCESS: Restored {filename} ({len(code)} bytes)")
            return True
    print(f"FAILURE: No {filename} found")
    return False

# Restore app.py and index.html
restore_file('app.py', r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\app.py")
restore_file('index.html', r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html")
