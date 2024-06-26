#!/bin/bash

BASE_PATH="/Users/abakhtin22/Documents/StaticTools/SARbenchmarks"
PROJECTS=$(<spring_project_list.txt)

for PROJECT in $PROJECTS; do
    PROJECT_PATH="${BASE_PATH}/${PROJECT}"
    echo $PROJECT
    curl --request POST \
        --url http://localhost:8081/ \
        --header 'content-type: application/json' \
        --data "{
        \"repositories\": [{\"path\": \"${PROJECT_PATH}\", \"isMonolith\": false, \"local\": true}], \"systemName\": \"${PROJECT}\"
    }" > "${BASE_PATH}/${PROJECT}-output/prophet-raw.json"
done

