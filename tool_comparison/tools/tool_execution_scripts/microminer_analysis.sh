#!/bin/bash
# Script assumes execution in root directory of M3SOulu/SARbenchmarks
# Path to local installation of MicroDepGraph has to be provided as first argument (pointing to folder containing its main.py)

TOOL_PATH="$1"
BASE_PATH="${2:-$(pwd)}"    # specified path to root of SARbenchmarks if provided as second argument, otherwise current working dir
KUBERNETES_PATHS="$BASE_PATH"/tool_configs/kubernetes_paths.txt

pushd "$TOOL_PATH"
while IFS= read -r kubernetes_path; do
    printf "\n---------------- \nAnalyzing $kubernetes_path \n\n"
    sudo python -m microMiner generate kubernetes "$BASE_PATH"/"$kubernetes_path" results/"$kubernetes_path"
done < "$KUBERNETES_PATHS"

popd

printf "\n All done.\n"