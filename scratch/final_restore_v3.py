import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\0154e747-3b96-4462-ad1c-690925051cb3\scratch\academic_v1_log.txt"
with open(log_path, 'r', encoding='utf-16le') as f:
    data = f.read()

# The code is between "the css should be like thissssssss (" and the end of the user request.
# In step 675.
start_marker = "the css should be like thissssssss ("
end_marker = ")\"}" # End of the content field in the JSON

start_idx = data.find(start_marker)
if start_idx != -1:
    start_idx += len(start_marker)
    # The content is a JSON string, so it might have escaped newlines \n and quotes \"
    # We find the end marker.
    end_idx = data.find(end_marker, start_idx)
    if end_idx != -1:
        raw_code = data[start_idx:end_idx]
        
        # Clean up escaping from JSON string
        clean_code = raw_code.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
        
        # Fix any artifacts from the log selection
        if clean_code.startswith('<!DOCTYPE html>'):
            target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
            with open(target, 'w', encoding='utf-8') as f_out:
                f_out.write(clean_code)
            print(f"SUCCESS: Extored {len(clean_code)} bytes of pure user code to index.html")
        else:
            print("FAILURE: Code does not start with DOCTYPE")
    else:
        print("FAILURE: End marker not found")
else:
    print("FAILURE: Start marker not found")
