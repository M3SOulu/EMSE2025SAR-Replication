#!/bin/bash

PROJECTS=$(<tool_configs/spring_project_list.txt)

for PROJECT in $PROJECTS; do
    echo "Analyzing projects $PROJECT"

    SERVICES=()
    PROJECT_PATH="${PWD}/analyzed_applications/${PROJECT}"
    SERVICE_LIST="tool_configs/rad_source/${PROJECT}-service-list.txt
    while IFS= read -r line; do
        SERVICES+=("$PROJECT_PATH/$line")
    done < "$SERVICE_LIST"
    json_array=$(printf '%s\n' "${SERVICES[@]}" | jq -R . | jq -s .)
    json_payload=$(jq -n --argjson paths "$json_array" '{"pathToMsRoots": $paths}')

    OUTPUT_PATH="raw_results/RAD-source"
    mkdir -p $OUTPUT_PATH
    curl --request POST \
        --url http://localhost:8080/ \
        --header 'content-type: application/json' \
        --data "$json_payload" > "$OUTPUT_PATH/${PROJECT}-rad-source-raw.json"
done

