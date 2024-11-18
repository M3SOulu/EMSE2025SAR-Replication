#!/bin/bash

PROJECTS=$(<tool_configs/spring_project_list.txt)

for PROJECT in $PROJECTS; do
    PROJECT_PATH="${PWD}/analyzed_applications/${PROJECT}"
    OUTPUT_PATH="${PWD}/raw_results/Prophet"
    RAW_PATH="${OUTPUT_PATH}/${PROJECT}-prophet-raw.json"
    GRAPH_PATH="${OUTPUT_PATH}/${PROJECT}-prophet-graph.mmd"
    mkdir -p $OUTPUT_PATH

    echo "Analyzing project $PROJECT"

    curl --request POST \
        --url http://localhost:8081/ \
        --header 'content-type: application/json' \
        --data "{
        \"repositories\": [{\"path\": \"${PROJECT_PATH}\", \"isMonolith\": false, \"local\": true}], \"systemName\": \"${PROJECT}\"
    }" > "$RAW_PATH"

    jq -r .global.communication $RAW_PATH > $GRAPH_PATH
done

