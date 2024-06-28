#!/bin/bash

PROJECTS=$(<spring_project_list.txt)

for PROJECT in $PROJECTS; do
    PROJECT_PATH="${PWD}/${PROJECT}"
    echo "Analyzing projects $PROJECT"
    curl --request POST \
        --url http://localhost:8080/ \
        --header 'content-type: application/json' \
        --data "{
      \"pathToMsRoots\": [\"${PROJECT_PATH}\"]
    }" > "${PROJECT_PATH}-output/rad-source-raw.json"
done

