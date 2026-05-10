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

# Search for the result of step 31 (Reading ml_app/app.py)
# The output starts after "Output":"
# We'll search for "import os" followed by "app = Flask"
start_marker = '"Output":"import os'
end_marker = 'if __name__ == \'__main__\''

start_idx = data.find(start_marker)
if start_idx != -1:
    start_idx += len('"Output":"')
    # Find the end of the Python file (usually where the last line of the script ends)
    # We'll search for the next closing quote and brace of the JSON
    json_end = data.find('"}', start_idx)
    if json_end != -1:
        raw_code_escaped = data[start_idx:json_end]
        code = raw_code_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
        
        target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\app.py"
        with open(target, 'w', encoding='utf-8') as f_out:
            f_out.write(code)
        print(f"SUCCESS: Restored baseline app.py ({len(code)} bytes)")
    else:
        print("FAILURE: JSON end not found")
else:
    print("FAILURE: start_marker not found")
