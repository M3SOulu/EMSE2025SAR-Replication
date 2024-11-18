## Comparison of Static Analysis Architecture Recovery Tools for Microservice Applications - Replication Package

This repository contins all data necessary to replicate the results presented in the above article.

## Repository structure



- ``````

- ```multivocal_literature_review/```: Data to replicate the identification of static architecture recovery tools for microservice applications.
    - ```gray_literature_review/```: Data for the review of gray literature (informally published) sources.
    - ```systematic_literature_review/```: Data for the review of academic (formally published) sources.
- ```tool_comparison```: Data to replicate the comparison of the identified tools.
    - ```analyzed_applications/```: The microservice applications that the tools are evaluated on as submodules.
    - ```groundtruth_textual/```: The groundtruth architectural models (dataflof diagrams, DFDs) of the applications that the tools are evaluated on as simple text documents.
    - ```helper_scripts/```: Some scripts we use to analyze the results.
    - ```processed_results/```: Quantifications of the tools' results, i.e., files for each tool indicating for each model item in the groundtruth whether the tool correctly extracted it or not.
    - ```raw_results/```: Rhe raw output of each tool after running them on the applications in ```analyzed_applications/```.
    - ```tool_configs/```: Configuration information for some of the tools.
    - ```tool_execution_scripts/```: Shell scripts for each tool that can be used to execute the tool on each application in ```analyzed_applications/```.

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
