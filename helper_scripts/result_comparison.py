import os
import csv

tools = ["attack-graph-generator",
         "code2DFD",
         "Contextmap",
         "MicroDepGraph",
         "microMiner",
         "Prophet",
         "RAD",
         "RAD-source"
         ]

applications = ["apache-spring-boot-microservice-example",
                "blog-microservices",
                "java-microservice",
                "microservice",
                "microservice-kafka",
                "microservices-basics-spring-boot",
                "microservices-sample",
                "piggymetrics",
                "sample-spring-oauth2-microservices",
                "spring-boot-microservices",
                "spring-boot-microservices-workshop",
                "spring-cloud-movie-recommendation",
                "spring-cloud-netflix-example",
                "spring-netflix-oss-microservices",
                "spring-petclinic-microservices",
                "Springboot-Microservice",
                "Tap-And-Eat-MicroServices"]



def parse_tool_result_file(application: str, tool: str) -> list:
    """Extracts tool's results from processed results file.
    """

    tool_results = list()


    return tool_results


def parse_groundtruth(application: str) -> list:
    """Parses the textual groundtruth file of the application and returns components as list.
    """

    components = list()


    return components



def main():

    # Check that all tool directories exist under correct name
    for tool in tools:
        tool_dir_path = os.path.join("..", "processed_results", tool)
        if not os.path.exists(tool_dir_path):
            print(f"Folder for {tool} does not exist at {tool_dir_path}")

    # Extract results per application
    for application in applications:
        combined_results = parse_groundtruth(application)
    
        for tool in tools:
            tool_results = parse_tool_result_file(application, tool)
            combined_results.append(tool_results)


        output_path = os.join()
        with open(output_path, "w", newline='') as output_file:
            writer = csv.writer(output_file)
            writer.writerows(combined_results)





if __name__ == "__main__":
    main()
