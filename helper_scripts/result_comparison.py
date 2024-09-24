import os

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

    try:
        results_file_path = os.path.join("..", "processed_results", tool, f"{application}-{tool}-processed.txt")
        with open(results_file_path, "r") as results_file:
            groundtruth = [line.strip().split(" ")[0] for line in results_file.readlines() if not line.strip() in ["Components:", "Connections:", "Endpoints:", ""]]
        return groundtruth
    except Exception as e:
        #print(e)
        return list()


def parse_groundtruth(application: str) -> list:
    """Parses the textual groundtruth file of the application and returns components as list.
    """

    try:
        groundtruth_file_path = os.path.join("..", "groundtruth_textual", f"{application}.txt")
        with open(groundtruth_file_path, "r") as groundtruth_file:
            groundtruth = [line.strip() for line in groundtruth_file.readlines()]# if not line.strip() in ["Components:", "Connections:", "Endpoints:", ""]]
            blank_1 = groundtruth.index("")
            groundtruth_partial = groundtruth[1:blank_1]
            groundtruth = groundtruth[blank_1 + 1:]
            blank_2 = groundtruth.index("")
            groundtruth_partial += groundtruth[1:blank_2]
        return groundtruth_partial
    except Exception as e:
        #print(e)
        return list()



def main():

    # Check that all tool directories exist under correct name
    for tool in tools:
        tool_dir_path = os.path.join("..", "processed_results", tool)
        if not os.path.exists(tool_dir_path):
            print(f"Folder for {tool} does not exist at {tool_dir_path}")

    # Extract results per application
    for application in applications:
        combined_results = list()
        combined_results.append(parse_groundtruth(application))
        num_components = len(combined_results[0])
        
    
        for tool in tools:
            tool_results = parse_tool_result_file(application, tool)
            if not tool_results:
                tool_results = ["/"] * num_components
            combined_results.append(tool_results[:num_components])

        print("\n")
        for c in combined_results:
            print(c)
        # output_path = os.path.join("..", "merged_results", f"{application}.csv")
        # with open(output_path, "w") as output_file:

        #     output_file.write()




if __name__ == "__main__":
    main()
