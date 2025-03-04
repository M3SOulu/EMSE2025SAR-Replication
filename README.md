## Comparison of Static Analysis Architecture Recovery Tools for Microservice Applications - Replication Package

This repository contains all data necessary to replicate the results presented in the above article.

## Repository structure

- ```multivocal_literature_review/```: Data to replicate the identification of static architecture recovery tools for microservice applications via a gray literature review (informally published sources) and a systematic literature review (formally published sources).
- ```tool_comparison```: Data to replicate the comparison of the identified tools.
    - ```analyzed_applications/```: The microservice applications that the tools are evaluated on as submodules. 
    - ```groundtruth_textual/```: The groundtruth architectural models (dataflof diagrams, DFDs) of the applications that the tools are evaluated on as simple text documents.
    - ```results/```: Results of the comparison.
        - ```execution_times/```: Results of measuring the execution times of each tool.
         - ```recovery_correctness/```: Results of the tools' correctness in recovering the analyzed applications' architecture.
            - ```merged_results/```: Results of all tools combined in a single file per analyzed application.
            - ```processed_results/```: Quantifications of the tools' results, i.e., files for each tool indicating for each model item in the groundtruth whether the tool correctly extracted it or not.
            - ```raw_results/```: The raw output of each tool after running them on the applications in the dataset.
    - ```tools/```: All files to run the identified tools.
        - ```helper_scripts/```: Some helper scripts we used to analyze the results and get the tools running initially.
        - ```tool_configs/```: Configuration information for some of the tools.
        - ```tool_execution_scripts/```: Shell scripts for each tool that can be used to execute the tool on each application in the dataset.

## Related repositories

Forks of all compared tools are preserved in the [Tools repository](https://github.com/M3SOulu/EMSE2025SAR-Tools)

Forks of all considered benchmarks are preserved in the [Benchmark repository](https://github.com/M3SOulu/EMSE2025SAR-Benchmarks)
