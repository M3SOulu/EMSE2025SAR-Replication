#!/bin/bash

python3 list_java_files.py microservice
curl -X POST -H "Content-Type: application/json" -d @output.json http://localhost:8080/ctx > "sourceparser.json"
