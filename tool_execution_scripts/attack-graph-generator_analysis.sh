#!/bin/bash
# Script assumes execution in root directory of M3SOulu/SARbenchmarks
# Path to local installation of attack-graph-generator has to be provided as first argument (pointing to folder containing its main.py)

TOOL_PATH="$1"
BASE_PATH="${2:-$(pwd)}"    # specified path to root of SARbenchmarks if provided as second argument, otherwise current working dir
#APPLICATIONS_BASE="$BASE_PATH"/analyzed_applications
DOCKER_COMPOSE_PATHS="$BASE_PATH"/tool_configs/docker_compose_paths.txt

pushd "$TOOL_PATH" #> /dev/null
echo "$BASE_PATH"
while IFS= read -r docker_compose_path; do
    printf "\n ---------------- \nanalyzing $docker_compose_path \n"
    sudo python3 main.py "$BASE_PATH"/"$docker_compose_path"

done < "$DOCKER_COMPOSE_PATHS"

popd #> /dev/null

printf "\n All done.\n"