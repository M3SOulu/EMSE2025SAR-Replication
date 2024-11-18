#!/bin/bash
PROJECT_FILE="tool_configs/compiled_spring_project_list.txt"

while IFS=, read -r PROJECT ORG_PATH; do
        PROJECT_PATH="${PWD}/analyzed_applications/$PROJECT"
        OUTPUT_PATH="${PWD}/raw_results/RAD"
        mkdir -p $OUTPUT_PATH

        echo "Analyzing project $PROJECT"

        curl --request POST \
            --url http://localhost:8080/ \
            --header 'content-type: application/json' \
            --data "{
              \"pathToCompiledMicroservices\": \"${PROJECT_PATH}\", \"organizationPath\":\"${ORG_PATH}\", \"outputPath\":\"${OUTPUT_PATH}/${PROJECT}-rad-raw-graph.json\"
          }" > "$OUTPUT_PATH/${PROJECT}-rad-raw-response.json"
done < "$PROJECT_FILE"

