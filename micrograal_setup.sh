#!/usr/bin/env bash
set -e


# the base directory of the benchmark
if [[ -z "${MS_ROOT}" ]]; then
  >&2 echo "MS_ROOT not set"
  exit 1
fi

#LIST ALL MICROSERVICE ROOTS IN SYSTEM

SERVICES=()
SERVICE_LIST=$MS_ROOT-service-list.txt
while IFS= read -r line; do
        SERVICES+=("$PROJECT_PATH/$line")
done < "$SERVICE_LIST"

directory="${MS_ROOT}"

cd $directory
mvn clean install -DskipTests
cd -

target_dir="target"
ending=".jar"

for microservice in "${SERVICES[@]}"; do
    fatjar="${directory}/${microservice}/${target_dir}/*${ending}"
    output_path="${directory}/${microservice}/${target_dir}"
    unzip -o $fatjar -d $output_path
    lib_dir="${directory}/${microservice}/${target_dir}/BOOT-INF/lib/"
    if [ -d "$lib_dir" ]; then
      file=$(find "$lib_dir" -name "snakeyaml*" -print -quit)
      if [ -f "$file" ]; then
          rm "$file"
      fi
    fi
done
