#!/bin/bash
PROJECT_FILE="${PWD}/tool_configs/compiled_spring_project_list.txt"

source ${PWD}/tool_configs/micrograal/micrograal_environment.env

while IFS=, read -r PROJECT ORG_PATH; do
        CONFIG_PATH=${PWD}/tool_configs/micrograal/$PROJECT-micrograal-config.json
        export MS_ROOT=${PWD}/analyzed_applications/$PROJECT
        OUTPUT_PATH="${PWD}/raw_results/Micrograal/${PROJECT}-micrograal-raw"
        mkdir -p $OUTPUT_PATH
        echo "Analyzing project $PROJECT"
        ${PWD}/tool_execution_scripts/micrograal_setup.sh $CONFIG_PATH
        $JAVA_HOME/bin/java -jar "${PROPHET_PLUGIN_HOME}"/graal-prophet-utils/target/graal-prophet-utils-0.0.8.jar $CONFIG_PATH > "$PROJECT-micrograal-log.log" 2>&1
        mv -f output* $OUTPUT_PATH
done < "$PROJECT_FILE"

