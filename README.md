# Comparison of Static Analysis Architecture Recovery Tools for Microservice Applications

This is a replication package for the paper titled Comparison of Static Analysis Architecture Recovery Tools for Microservice Applications.

## Repository structure

- ```analyzed_applications/``` contains the microservice applications that the tools are evaluated on as submodules
- ```groundtruth_textual/``` contains the groundtruth architectural models (dataflof diagrams / DFDs) of the applications that the tools are evaluated on as simple text documents
- ```helper_scripts/``` contains some scripts we use to analyze the results
- ```processed_results/``` contains quantifications of the tools' results, i.e., files for each tool indicating for each model item in the groundtruth whether the tool correctly extracted it or not
- ```raw_results/``` contains the raw output of each tool after running them on the applications in the groundtruth
- ```service_lists/``` contains a file per application in the groundtruth with the services that exist in that application. Needed for executing some tools
- ```tool_configs/``` contains configuration information for some of the tools
- ```tool_execution_scripts/``` contains a shell script per tool that can be used to execute the tool on each application in the groundtruth



## Initializing repository

This repository should be cloned as follows:

```shell
git clone https://github.com/M3SOulu/SARbenchmarks.git
git submodule init
git submodule update
```

Or, in one line:

```shell
git clone --recurse-submodules https://github.com/M3SOulu/SARbenchmarks.git
```
