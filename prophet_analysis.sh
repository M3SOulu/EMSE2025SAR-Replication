#!/bin/bash

PROJECTS=$(<spring_project_list.txt)

for PROJECT in $PROJECTS; do
    PROJECT_PATH="${PWD}/${PROJECT}"
    OUTPUT_PATH=${PROJECT_PATH}-output
    echo "Analyzing project $PROJECT"
    curl --request POST \
        --url http://localhost:8081/ \
        --header 'content-type: application/json' \
        --data "{
        \"repositories\": [{\"path\": \"${PROJECT_PATH}\", \"isMonolith\": false, \"local\": true}], \"systemName\": \"${PROJECT}\"
    }" > "$OUTPUT_PATH/prophet-raw.json"
done

