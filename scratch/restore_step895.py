import os
import re

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\a863d7e3-62d0-40c2-ba7c-94e42ae45600\.system_generated\logs\overview.txt"
with open(log_path, 'rb') as f:
    raw_data = f.read()

try:
    data = raw_data.decode('utf-16-le', errors='ignore')
except:
    data = raw_data.decode('utf-8', errors='ignore')

# Search for step_index: 895
# This step was the "Immediate Undo"
search_str = '"step_index":895'
start_pos = data.find(search_str)
if start_pos != -1:
    # Find the CodeContent in this step or subsequent steps
    # Actually, step 895 was a PLANNER_RESPONSE with tool_calls
    # Let's find the write_to_file after step 895
    write_pos = data.find('"name":"write_to_file"', start_pos)
    if write_pos != -1:
        cc_match = re.search(r'"CodeContent":"(.*?)(?<!\\)"', data[write_pos:], re.DOTALL)
        if cc_match:
            raw_html_escaped = cc_match.group(1)
            html = raw_html_escaped.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
            
            target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
            with open(target, 'w', encoding='utf-8') as f_out:
                f_out.write(html)
            print(f"SUCCESS: Restored index.html from Step 895 ({len(html)} bytes)")
            exit()

print("FAILURE: Could not find Step 895 or its CodeContent")
