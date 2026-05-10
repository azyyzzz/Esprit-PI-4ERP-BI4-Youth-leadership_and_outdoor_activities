import os

target = r"c:\Users\MSI\Desktop\wetransfer_scouts_2026-02-28_1339\Scouts\ml_app\templates\index.html"
with open(target, 'r', encoding='utf-8') as f:
    data = f.read()

start_tag = "<!DOCTYPE html>"
end_tag = "</html>"

start_idx = data.find(start_tag)
end_idx = data.find(end_tag)

if start_idx != -1 and end_idx != -1:
    end_idx += len(end_tag)
    clean_html = data[start_idx:end_idx]
    
    # Also unescape some leftovers if any
    clean_html = clean_html.replace('\\n', '\n').replace('\\"', '"').replace('\\\\', '\\')
    
    with open(target, 'w', encoding='utf-8') as f_out:
        f_out.write(clean_html)
    print(f"SUCCESS: Cleaned HTML. Final size: {len(clean_html)} bytes")
else:
    print(f"FAILURE: Start {start_idx}, End {end_idx}")
