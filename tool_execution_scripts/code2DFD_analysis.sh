#!/bin/bash

PROJECT_FILE="spring_project_list.txt"

while IFS= read -r application; do
    python3 code2dfd.py --github_path "$application"
done < "$PROJECT_FILE"