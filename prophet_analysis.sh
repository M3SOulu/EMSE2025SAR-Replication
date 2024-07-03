#!/bin/bash

PROJECTS=$(<spring_project_list.txt)

for PROJECT in $PROJECTS; do
    PROJECT_PATH="${PWD}/${PROJECT}"
    OUTPUT_PATH=${PROJECT_PATH}-output
    RAW_PATH=${OUTPUT_PATH}/prophet-raw.json
    PROCESSED_PATH=${OUTPUT_PATH}/prophet-processed.mmd
    echo "Analyzing project $PROJECT"
    curl --request POST \
        --url http://localhost:8081/ \
        --header 'content-type: application/json' \
        --data "{
        \"repositories\": [{\"path\": \"${PROJECT_PATH}\", \"isMonolith\": false, \"local\": true}], \"systemName\": \"${PROJECT}\"
    }" > "$RAW_PATH"
    jq -r .global.communication $RAW_PATH > $PROCESSED_PATH
done

