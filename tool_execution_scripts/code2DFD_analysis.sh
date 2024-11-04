#!/bin/bash
# Script assumes execution in root directory of M3SOulu/SARbenchmarks
# Path to local installation of Code2DFD has to be provided as first argument (pointing to folder containing its main.py)

TOOL_PATH="$1"
BASE_PATH="${2:-$(pwd)}"    # specified path to root of SARbenchmarks if provided as second argument, otherwise current working dir
SPRING_PROJECTS="$BASE_PATH"/tool_configs/github_handles.txt

pushd "$TOOL_PATH"
while IFS= read -r application; do
    printf "\n---------------- \nAnalyzing $kubernetes_path \n\n"
    python3 code2dfd.py "$application"
done < "$SPRING_PROJECTS"

popd

printf "\n All done.\n"