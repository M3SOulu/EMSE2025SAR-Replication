#!/bin/bash
PROJECT_FILE="compiled_spring_project_list.txt"

source ./micrograal_environment.env

while IFS=, read -r PROJECT ORG_PATH; do
        CONFIG_PATH=./$PROJECT-micrograal-config.json
        export MS_ROOT=${PWD}/$PROJECT
        OUTPUT_PATH="${MS_ROOT}-output"
        mkdir -p $OUTPUT_PATH
        echo "Analyzing project $PROJECT"
        ./micrograal_setup.sh $CONFIG_PATH
        $JAVA_HOME/bin/java -jar "${PROPHET_PLUGIN_HOME}"/graal-prophet-utils/target/graal-prophet-utils-0.0.8.jar $CONFIG_PATH
        mv -f output* $OUTPUT_PATH/micrograal-raw
done < "$PROJECT_FILE"

