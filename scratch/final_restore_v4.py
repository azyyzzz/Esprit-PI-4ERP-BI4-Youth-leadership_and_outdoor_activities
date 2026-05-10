import os

log_path = r"C:\Users\MSI\.gemini\antigravity\brain\0154e747-3b96-4462-ad1c-690925051cb3\scratch\academic_v1_log.txt"
with open(log_path, 'r', encoding='utf-16le') as f:
    data = f.read()

start_marker = "the css should be like thissssssss ("
end_marker = "</html>"

start_idx = data.find(start_marker)
if start_idx != -1:
    start_idx += len(start_marker)
    end_idx = data.find(end_marker, start_idx)
    if end_idx != -1:
        end_idx += len("</html>")
        raw_code = data[start_idx:end_idx]
        clean_code = raw_code.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
        
        target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
        with open(target, 'w', encoding='utf-8') as f_out:
            f_out.write(clean_code)
        print(f"SUCCESS: Extracted {len(clean_code)} bytes to index.html")
    else:
        print("FAILURE: End marker </html> not found")
else:
    print("FAILURE: Start marker not found")
