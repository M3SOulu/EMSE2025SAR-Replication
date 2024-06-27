#!/bin/bash
PROJECT_FILE="compiled_spring_project_list.txt"

while IFS=, read -r PROJECT ORG_PATH; do
        PATH_HERE=${PWD}/$PROJECT
        OUTPUT_PATH="${PATH_HERE}-output/rad-raw"
        mkdir -p $OUTPUT_PATH
        curl --request POST \
            --url http://localhost:8080/ \
            --header 'content-type: application/json' \
            --data "{
              \"pathToCompiledMicroservices\": \"${PATH_HERE}\", \"organizationPath\":\"${ORG_PATH}\", \"outputPath\":\"${OUTPUT_PATH}/rad-graph.json\"
          }" > "$OUTPUT_PATH/rad-response.json"
done < "$PROJECT_FILE"

