import os

tools = [("attack-graph-generator", 12),
         ("code2DFD", 17),
         ("MicroDepGraph", 10),
         ("microMiner", 5),
         ("Prophet", 17),
         ("RAD", 13),
         ("RAD-source", 17)
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
        # print(e)
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

    # Check that all tool directories exist under correct name and that files can be read
    for tool_tuple in tools:
        tool = tool_tuple[0]
        tool_dir_path = os.path.join("..", "processed_results", tool)
        if not os.path.exists(tool_dir_path):
            print(f"Folder for {tool} does not exist at {tool_dir_path}")

        # check for each tool that expected number of result files is parsed successfully
        file_count = 0
        for application in applications:
            try:
                results_file_path = os.path.join("..", "processed_results", tool, f"{application}-{tool}-processed.txt")
                with open(results_file_path, "r") as results_file:
                    file_count += 1
            except Exception as e:
                #print(e)
                pass
        if not file_count == tool_tuple[1]:
            print(f"Number of successfully opened files not as expected for tool {tool}")

    # Extract results per application
    for application in applications:
        combined_results = list()
        combined_results.append(["Groundtruth"] + parse_groundtruth(application))
        num_components = len(combined_results[0])
        
    
        for tool_tuple in tools:
            tool = tool_tuple[0]
            tool_results = [tool] + parse_tool_result_file(application, tool)
            if len(tool_results) == 1:
                tool_results += ["/"] * num_components
            combined_results.append(tool_results[:num_components])


        # Looks and is very hacky, but works (opposed to csv library)
        output_path = os.path.join("..", "merged_results", f"{application}.csv")
        with open(output_path, "w") as output_file:
            for i, component in enumerate(combined_results[0]):
                output_file.write(component)
                for tool in combined_results[1:]:
                    #print(application)
                    #print(tool)
                    output_file.write(f", {tool[i]}")
                output_file.write("\n")




if __name__ == "__main__":
    main()
