import sys
import zipfile
import xml.etree.ElementTree as ET

def read_docx(path):
    with zipfile.ZipFile(path) as docx:
        xml_content = docx.read('word/document.xml')
        tree = ET.fromstring(xml_content)
        ns = {'w': 'http://schemas.openxmlformats.org/wordprocessingml/2006/main'}
        text = []
        for p in tree.iterfind('.//w:p', ns):
            para_text = "".join(node.text for node in p.iterfind('.//w:t', ns) if node.text)
            if para_text:
                text.append(para_text)
        return '\n'.join(text)

print(read_docx(sys.argv[1]))
