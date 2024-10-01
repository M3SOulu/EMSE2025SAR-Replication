#!/bin/bash

PROJECTS=$(<spring_project_list.txt)

for PROJECT in $PROJECTS; do
    echo "Analyzing projects $PROJECT"

    SERVICES=()
    PROJECT_PATH="${PWD}/${PROJECT}"
    SERVICE_LIST=$PROJECT_PATH-service-list.txt
    while IFS= read -r line; do
        SERVICES+=("$PROJECT_PATH/$line")
    done < "$SERVICE_LIST"
    json_array=$(printf '%s\n' "${SERVICES[@]}" | jq -R . | jq -s .)
    json_payload=$(jq -n --argjson paths "$json_array" '{"pathToMsRoots": $paths}')

    OUTPUT_PATH=${PROJECT_PATH}-output
    mkdir -p $OUTPUT_PATH
    curl --request POST \
        --url http://localhost:8080/ \
        --header 'content-type: application/json' \
        --data "$json_payload" > "$OUTPUT_PATH/rad-source-raw.json"
done

