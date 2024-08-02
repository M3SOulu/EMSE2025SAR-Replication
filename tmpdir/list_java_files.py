from copy import deepcopy
import sys
import json
import os


BASE_DICT = {"path": None, "files": [], "subDirectories": []}


def parse_files(root):
    root = os.path.abspath(root)
    files = deepcopy(BASE_DICT)
    files['path'] = root
    for file in os.listdir(root):
        if file.startswith('.'): continue
        if file in {'mvnw', 'test', 'target'}: continue
        file = os.path.join(root, file)
        if os.path.isfile(file) and os.path.splitext(file)[1] == ".java":
            print(file)
            files['files'].append(os.path.join(root,file))
        elif os.path.isdir(file):
            sub_dir = parse_files(file)
            if not (len(sub_dir['files'])==0 and len(sub_dir['subDirectories'])==0):
                files['subDirectories'].append(sub_dir)
    return files
        
        



STRUCTURE = parse_files(sys.argv[1])

with open('output.json', 'w') as f:
    json.dump(STRUCTURE, f, separators=(',', ':'))
