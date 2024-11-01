#!/bin/bash
# Script assumes execution in root directory of M3SOulu/SARbenchmarks
# Path to local installation of MicroDepGraph has to be provided as first argument (pointing to folder containing its main.py)

TOOL_PATH="$1"
BASE_PATH="${2:-$(pwd)}"    # specified path to root of SARbenchmarks if provided as second argument, otherwise current working dir
DOCKER_COMPOSE_PROJECTS="$BASE_PATH"/tool_configs/docker_compose_projects.txt

pushd "$TOOL_PATH"
while IFS= read -r docker_compose_project; do
    printf "\n ---------------- \nanalyzing $docker_compose_path \n"
    java -jar microservices.comm.pattern.check-1.0-SNAPSHOT-jar-with-dependencies.jar "$BASE_PATH"/analyzed_applications/"$docker_compose_project" "$docker_compose_project"
done < "$DOCKER_COMPOSE_PROJECTS"

popd

printf "\n All done.\n"