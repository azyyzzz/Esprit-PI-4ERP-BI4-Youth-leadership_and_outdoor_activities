import json
import re
import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\0154e747-3b96-4462-ad1c-690925051cb3\scratch\academic_v1_log.txt"
if not os.path.exists(log_path):
    print("FAILURE: Log file not found")
    exit()

with open(log_path, 'r', encoding='utf-16le') as f:
    data = f.read()

# The log entry is a JSON object. We need to parse it.
# It starts with {"step_index":670
try:
    # Find the JSON block
    match = re.search(r'\{"step_index":670.*', data, re.DOTALL)
    if match:
        json_str = match.group(0)
        # The JSON might be truncated in the log excerpt, so we find the end of the step
        # But actually, we just need the CodeContent part.
        
        # Look for the CodeContent value
        # It's a string inside a JSON, so it's escaped.
        cc_match = re.search(r'"CodeContent":"(.*?)(?<!\\)"', json_str, re.DOTALL)
        if cc_match:
            raw_html_escaped = cc_match.group(1)
            # Unescape: replace \n with newline, \" with quote, etc.
            html = raw_html_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
            
            target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
            with open(target, 'w', encoding='utf-8') as f_out:
                f_out.write(html)
            print(f"SUCCESS: Extracted and wrote {len(html)} bytes to index.html")
        else:
            print("FAILURE: Could not find CodeContent in JSON")
    else:
        print("FAILURE: Could not find step 670 in log file")
except Exception as e:
    print(f"ERROR: {str(e)}")
