import subprocess
import os
import glob
import click
import csv
import json
import re


plugin_path = "/opt/third_party/binaries/protoc-gen-scip"
convert_path = "/opt/third_party/binaries/convert"
scip_go_path = "/opt/third_party/binaries/scip-go"
scip_clang_path = "/opt/third_party/binaries/scip-clang"
base_path = os.getcwd()

# subprocess.run(["make", "all"])


def monitor(cmd: list, log_file: str, interval: float):
    psrecord_cmd = ["/usr/bin/time", "-v"]+cmd
    result = subprocess.run(psrecord_cmd, stderr=subprocess.PIPE)

    message = result.stderr.decode()
    user_time_match = re.search(r'User time \(seconds\): (\d+\.?\d*)', message)
    max_resident_set_size_match = re.search(
        r'Maximum resident set size \(kbytes\): (\d+)', message)

    user_time = float(user_time_match.group(1)) if user_time_match else None
    max_resident_set_size = int(max_resident_set_size_match.group(
        1)) if max_resident_set_size_match else None
    print(message)
    print(
        f"Time: {str(user_time)}s, Memory: {str(max_resident_set_size//1000)}MB")
    return user_time, max_resident_set_size//1000


def parse_psrecord_log(log_file):
    cpu_times = []
    memory_usage = []

    with open(log_file, "r") as f:
        lines = f.readlines()
        lines = lines[1:]
        for line in lines:
            values = line.split()
            if len(values) == 4:
                elapsed_time = float(values[0])
                real_memory = float(values[2])
                cpu_times.append(elapsed_time)
                memory_usage.append(
                    real_memory)
    if len(cpu_times) == 0 or len(memory_usage) == 0:
        return 0, 0
    return max(cpu_times), max(memory_usage)


def gen_go_scip(module_root: str, project_root: str, output_file: str):
    return [scip_go_path, f"--module-root={module_root}", f"--project-root={project_root}", f"--output={output_file}"]


def gen_ts_scip(project_root, output_file):
    return ["scip-typescript", "index", project_root, "--output", output_file]


def gen_py_scip(project_root, output_file):
    os.chdir(base_path+"/"+project_root)
    return ["scip-python", "index", './', "--project-name", project_root, "--output", output_file]


def gen_java_scip(project_root, output_file):
    return [project_root +"/generate_index.sh", output_file]


def gen_cpp_scip(project_root, output_file):
    os.chdir(base_path+"/"+project_root)
    return [scip_clang_path, "--compdb-path="+"build/compile_commands.json", "--index-output-path="+"../"+output_file]

def gen_cpp_lsif(project_root):
    return [os.path.join(base_path, project_root,"generate_lsif.sh")]

def gen_java_lsif(project_root):
    return [os.path.join(base_path, project_root,"generate_lsif.sh")]

def gen_py_lsif(project_root):
    return [os.path.join(base_path, project_root,"generate_lsif.sh")]

def gen_ts_lsif(project_root):
    os.chdir(os.path.join(base_path, project_root))
    return ["lsif-tsc", "-p", "."]

def gen_go_lsif(project_root):
    return [os.path.join(base_path, project_root,"generate_lsif.sh")]


def gen_ts():
    monitor(gen_ts_scip("Ts_A", "tsa.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_ts_scip("Ts_B", "tsb.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_ts_scip("Ts_C", "tsc.scip"), "/tmp/11111.log", 0.0001)


def gen_py():
    monitor(gen_py_scip("Python_A", "pya.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_py_scip("Python_B", "pyb.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_py_scip("Python_C", "pyc.scip"), "/tmp/11111.log", 0.0001)
    os.chdir(base_path)
    subprocess.run(['mv', 'Python_A/pya.scip', "."])
    subprocess.run(['mv', 'Python_B/pyb.scip', "."])
    subprocess.run(['mv', 'Python_C/pyc.scip', "."])


def gen_go():
    monitor(gen_go_scip('Go_A', 'Go_A', 'goa.scip'), "/tmp/11111.log", 0.0001)
    monitor(gen_go_scip('Go_B', 'Go_B', 'gob.scip'), "/tmp/11111.log", 0.0001)
    monitor(gen_go_scip('Go_C', 'Go_C', 'goc.scip'), "/tmp/11111.log", 0.0001)


def gen_java():
    monitor(gen_java_scip("Java_A", "javaa.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_java_scip("Java_B", "javab.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_java_scip("Java_C", "javac.scip"), "/tmp/11111.log", 0.0001)
    os.chdir(base_path)


def gen_cpp():
    monitor(gen_cpp_scip("Cpp_A", "cppa.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_cpp_scip("Cpp_B", "cppb.scip"), "/tmp/11111.log", 0.0001)
    monitor(gen_cpp_scip("Cpp_C", "cppc.scip"), "/tmp/11111.log", 0.0001)


def total():
    os.chdir(base_path)
    if os.path.exists("total.scip"):
    # 如果存在，删除文件
        os.remove("total.scip")
    proto_files = glob.glob('protos/*.proto')
    command = [
        "protoc",
        f"--plugin={plugin_path}",
        "--scip_out=./",
        f"--scip_opt=scip_dir=./,sourceroot={base_path},out_file=total.scip",
        "-I",
        ".",
    ] + proto_files
    return monitor(command, "/tmp/111111.log", 0.000001)


def tidy():
    if os.path.exists("total.scip"):
        os.remove("total.scip")
    file = []
    file.extend(glob.glob('*.log'))
    file.extend(glob.glob('*.scip'))
    file.extend(glob.glob('*.lsif'))

    for file_name in file:
        try:
            os.remove(file_name)
        except OSError as e:
            print(f"Error: {file_name} : {e.strerror}")


@click.group()
def cli():
    pass

@cli.command()
def gen_lsif():
    perf = {}
    perf["Cpp_A"] = monitor(gen_cpp_lsif("Cpp_A"), "/tmp/11111.log", 0.0001)
    perf["Cpp_B"] = monitor(gen_cpp_lsif("Cpp_B"), "/tmp/11111.log", 0.0001)
    perf["Cpp_C"] = monitor(gen_cpp_lsif("Cpp_C"), "/tmp/11111.log", 0.0001)

    perf["Go_A"] = monitor(gen_go_lsif("Go_A"), "/tmp/11111.log", 0.0001)
    perf["Go_B"] = monitor(gen_go_lsif("Go_B"), "/tmp/11111.log", 0.0001)
    perf["Go_C"] = monitor(gen_go_lsif("Go_C"), "/tmp/11111.log", 0.0001)

    perf["Python_A"] = monitor(gen_py_lsif("Python_A"), "/tmp/11111.log", 0.0001)
    perf["Python_B"] = monitor(gen_py_lsif("Python_B"), "/tmp/11111.log", 0.0001)
    perf["Python_C"] = monitor(gen_py_lsif("Python_C"), "/tmp/11111.log", 0.0001)

    perf["Ts_A"] = monitor(gen_ts_lsif("Ts_A"), "/tmp/11111.log", 0.0001)
    perf["Ts_B"] = monitor(gen_ts_lsif("Ts_B"), "/tmp/11111.log", 0.0001)
    perf["Ts_C"] = monitor(gen_ts_lsif("Ts_C"), "/tmp/11111.log", 0.0001)
    os.chdir(base_path)

    with open('lsif.output.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        # for i, value in perf.items():
        #     cnt = 0
        # prev = None
        for i, value in perf.items():
            # cpu = sum([j[0] for j in value])/len(value)
            # mem = sum([j[1] for j in value])/len(value)
            # if cnt % 2 == 0:
            #     prev = (cpu, mem)
            #     writer.writerow([i, cpu, mem])
            # else:
            #     if prev[0] == 0:
            #         continue
            #     if prev[1] == 0:
            #         continue
                writer.writerow(
                    [i, value[0], value[1]])
            # cnt += 1



@cli.command()
def gen_simple_scip():
    """This command generate the base scip index file of Python, Java, Go, C++, Typescipt projects."""
    click.echo('Begin to generate...')
    click.echo('Generating Typescript SCIP index...')
    gen_ts()
    click.echo('Generating Java SCIP index...')
    gen_java()
    click.echo('Generating Go SCIP index...')
    gen_go()
    click.echo('Generating Python SCIP index...')
    gen_py()
    click.echo('Generating Cpp SCIP index...')
    gen_cpp()
    click.echo('Done!')


@cli.command()
def gen_merged_scip():
    """This command merge and add relationshiops between the base scip index file of Python, Java, Go, C++, Typescipt projects and proto files."""
    click.echo('Generating merged SCIP index...')
    total()
    click.echo('Done!')


@cli.command()
def clean():
    """This command remove the benchmark testing files"""
    tidy()


@cli.command()
def performance_merge_every():
    """This command will run every scip index, and merge it into the total.scip index. 
    The result is the output.csv.
    This process will be processed 20 times."""
    perf = {}
    num = 20
    perf['Ts_A'] = []
    perf['Ts_A_m'] = []
    tidy()
    for _ in range(num):
        perf['Ts_A'].append(
            monitor(gen_ts_scip("Ts_A", "tsa.scip"), "/tmp/11111.log", 0.0001))
        perf['Ts_A_m'].append(total())
        tidy()

    perf['Ts_B'] = []
    perf['Ts_B_m'] = []
    tidy()
    for _ in range(num):
        perf['Ts_B'].append(
            monitor(gen_ts_scip("Ts_B", "tsb.scip"), "/tmp/11111.log", 0.0001))
        perf['Ts_B_m'].append(total())
        tidy()

    perf['Ts_C'] = []
    perf['Ts_C_m'] = []
    tidy()
    for _ in range(num):
        perf['Ts_C'].append(
            monitor(gen_ts_scip("Ts_C", "tsc.scip"), "/tmp/11111.log", 0.0001))
        perf['Ts_C_m'].append(total())
        tidy()

    os.chdir(base_path)
    perf['Python_A'] = []
    perf['Python_A_m'] = []
    tidy()
    for _ in range(num):
        perf['Python_A'].append(
            monitor(gen_py_scip("Python_A", "pya.scip"), "/tmp/11111.log", 0.0001))
        os.chdir(base_path)
        subprocess.run(['mv', 'Python_A/pya.scip', "."])
        perf['Python_A_m'].append(total())
        tidy()

    perf['Python_B'] = []
    perf['Python_B_m'] = []
    tidy()
    for _ in range(num):
        perf['Python_B'].append(
            monitor(gen_py_scip("Python_B", "pyb.scip"), "/tmp/11111.log", 0.0001))
        os.chdir(base_path)
        subprocess.run(['mv', 'Python_B/pyb.scip', "."])
        perf['Python_B_m'].append(total())
        tidy()
    perf['Python_C'] = []
    perf['Python_C_m'] = []
    tidy()
    for _ in range(num):
        perf['Python_C'].append(
            monitor(gen_py_scip("Python_C", "pyc.scip"), "/tmp/11111.log", 0.0001))
        os.chdir(base_path)
        subprocess.run(['mv', 'Python_C/pyc.scip', "."])
        perf['Python_C_m'].append(total())
        tidy()

    perf['Go_A'] = []
    perf['Go_A_m'] = []
    tidy()
    for _ in range(num):
        perf['Go_A'].append(
            monitor(gen_go_scip('Go_A', 'Go_A', 'goa.scip'), "/tmp/11111.log", 0.0001))
        perf['Go_A_m'].append(total())
        tidy()
    perf['Go_B'] = []
    perf['Go_B_m'] = []
    tidy()
    for _ in range(num):
        perf['Go_B'].append(
            monitor(gen_go_scip('Go_B', 'Go_B', 'gob.scip'), "/tmp/11111.log", 0.0001))
        perf['Go_B_m'].append(total())
        tidy()
    perf['Go_C'] = []
    perf['Go_C_m'] = []
    tidy()
    for _ in range(num):
        perf['Go_C'].append(
            monitor(gen_go_scip('Go_C', 'Go_C', 'goc.scip'), "/tmp/11111.log", 0.0001))
        perf['Go_C_m'].append(total())
        tidy()
    os.chdir(base_path)
    perf['Java_A'] = []
    perf['Java_A_m'] = []
    tidy()
    for _ in range(num):
        perf['Java_A'].append(
            monitor(gen_java_scip("Java_A", "javaa.scip"), "/tmp/11111.log", 0.0001))
        os.chdir(base_path)
        perf['Java_A_m'].append(total())
        tidy()

    perf['Java_B'] = []
    perf['Java_B_m'] = []
    tidy()
    for _ in range(num):
        perf['Java_B'].append(
            monitor(gen_java_scip("Java_B", "javab.scip"), "/tmp/11111.log", 0.0001))
        os.chdir(base_path)
        perf['Java_B_m'].append(total())
        tidy()
    perf['Java_C'] = []
    perf['Java_C_m'] = []
    tidy()
    for _ in range(num):
        perf['Java_C'].append(
            monitor(gen_java_scip("Java_C", "javac.scip"), "/tmp/11111.log", 0.0001))
        os.chdir(base_path)
        perf['Java_C_m'].append(total())
        tidy()
    os.chdir(base_path)

    perf['Cpp_A'] = []
    perf['Cpp_A_m'] = []
    tidy()
    for _ in range(num):
        perf['Cpp_A'].append(
            monitor(gen_cpp_scip("Cpp_A", "cppa.scip"), "/tmp/11111.log", 0.0001))
        perf['Cpp_A_m'].append(total())
        tidy()

    os.chdir(base_path)

    perf['Cpp_B'] = []
    perf['Cpp_B_m'] = []
    tidy()
    for _ in range(num):
        perf['Cpp_B'].append(
            monitor(gen_cpp_scip("Cpp_B", "cppa.scip"), "/tmp/11111.log", 0.0001))
        perf['Cpp_B_m'].append(total())
        tidy()

    os.chdir(base_path)

    perf['Cpp_C'] = []
    perf['Cpp_C_m'] = []
    tidy()
    for _ in range(num):
        perf['Cpp_C'].append(
            monitor(gen_cpp_scip("Cpp_C", "cppa.scip"), "/tmp/11111.log", 0.0001))
        perf['Cpp_C_m'].append(total())
        tidy()

    os.chdir(base_path)

    with open('output.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        for i, value in perf.items():
            cnt = 0
        prev = None
        for i, value in perf.items():
            cpu = sum([j[0] for j in value])/len(value)
            mem = sum([j[1] for j in value])/len(value)
            if cnt % 2 == 0:
                prev = (cpu, mem)
                writer.writerow([i, cpu, mem])
            else:
                if prev[0] == 0:
                    continue
                if prev[1] == 0:
                    continue
                writer.writerow(
                    [i, cpu, mem, cpu/prev[0]*100, mem/prev[1]*100])
            cnt += 1


@cli.command()
def performance_merge_once():
    """This command will run the all process 20 times and output the report as output.csv"""
    perf = {}
    num = 20
    perf['Ts_A'] = []
    for _ in range(num):
        perf['Ts_A'].append(
            monitor(gen_ts_scip("Ts_A", "tsa.scip"), "/tmp/11111.log", 0.0001))
    perf['Ts_B'] = []
    for _ in range(num):
        perf['Ts_B'].append(
            monitor(gen_ts_scip("Ts_B", "tsb.scip"), "/tmp/11111.log", 0.0001))
    perf['Ts_C'] = []
    for _ in range(num):
        perf['Ts_C'].append(
            monitor(gen_ts_scip("Ts_C", "tsc.scip"), "/tmp/11111.log", 0.0001))
    perf['Python_A'] = []
    for _ in range(num):
        perf['Python_A'].append(
            monitor(gen_py_scip("Python_A", "pya.scip"), "/tmp/11111.log", 0.0001))
    perf['Python_B'] = []
    for _ in range(num):
        perf['Python_B'].append(
            monitor(gen_py_scip("Python_B", "pyb.scip"), "/tmp/11111.log", 0.0001))
    perf['Python_C'] = []
    for _ in range(num):
        perf['Python_C'].append(
            monitor(gen_py_scip("Python_C", "pyc.scip"), "/tmp/11111.log", 0.0001))
    os.chdir(base_path)
    subprocess.run(['mv', 'Python_A/pya.scip', "."])
    subprocess.run(['mv', 'Python_B/pyb.scip', "."])
    subprocess.run(['mv', 'Python_C/pyc.scip', "."])

    perf['Go_A'] = []
    for _ in range(num):
        perf['Go_A'].append(
            monitor(gen_go_scip('Go_A', 'Go_A', 'goa.scip'), "/tmp/11111.log", 0.0001))
    perf['Go_B'] = []
    for _ in range(num):
        perf['Go_B'].append(
            monitor(gen_go_scip('Go_B', 'Go_B', 'gob.scip'), "/tmp/11111.log", 0.0001))
    perf['Go_C'] = []
    for _ in range(num):
        perf['Go_C'].append(
            monitor(gen_go_scip('Go_C', 'Go_C', 'goc.scip'), "/tmp/11111.log", 0.0001))
    os.chdir(base_path)
    perf['Java_A'] = []
    for _ in range(num):
        perf['Java_A'].append(
            monitor(gen_java_scip("Java_A", "javaa.scip"), "/tmp/11111.log", 0.0001))
    perf['Java_B'] = []
    for _ in range(num):
        perf['Java_B'].append(
            monitor(gen_java_scip("Java_B", "javab.scip"), "/tmp/11111.log", 0.0001))
    perf['Java_C'] = []
    for _ in range(num):
        perf['Java_C'].append(
            monitor(gen_java_scip("Java_C", "javac.scip"), "/tmp/11111.log", 0.0001))
    os.chdir(base_path)
    perf['Cpp_A'] = []
    for _ in range(num):
        perf['Cpp_A'].append(
            monitor(gen_cpp_scip("Cpp_A", "cppa.index"), "/tmp/11111.log", 0.0001))
    perf['Cpp_B'] = []
    for _ in range(num):
        perf['Cpp_B'].append(
            monitor(gen_cpp_scip("Cpp_B", "cppa.index"), "/tmp/11111.log", 0.0001))
    perf['Cpp_C'] = []
    for _ in range(num):
        perf['Cpp_C'].append(
            monitor(gen_cpp_scip("Cpp_C", "cppa.index"), "/tmp/11111.log", 0.0001))
    os.chdir(base_path)
    perf['total'] = []
    for _ in range(num):
        os.remove("total.scip")
        perf['total'].append(total())

    with open('output.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        for i, value in perf.items():
            cnt = 0
        prev = None
        for i, value in perf.items():
            cpu = sum([j[0] for j in value])/len(value)
            mem = sum([j[1] for j in value])/len(value)
            if cnt % 2 == 0:
                prev = (cpu, mem)
                writer.writerow([i, cpu, mem])
            else:
                writer.writerow(
                    [i, cpu, mem, cpu/prev[0]*100, mem/prev[1]*100])
            cnt += 1


def vertex_stmt(label, properties: dict):
    prop = []
    for i, v in properties.items():
        if isinstance(v, dict):
            for key, value in v.items():
                prop.append(f'{str(i)}_{key}' + ":" + '"' + str(value) + '"')
        else:
            prop.append(str(i) + ":" + '"' + str(v) + '"')
    stmt = "CREATE (n0 {} {})".format(":" + label, "{" + ",".join(prop) + "}")
    return stmt


def edge_stmt(label, properties: dict):
    if "inV" in properties:
        conInV = '{{id: "{}"}}'.format(properties['inV'])
        conOutV = '{{id: "{}"}}'.format(properties['outV'])
        edge_label = label.split("/")[-1]
        edge_prop = []
        for i, v in properties.items():
            if isinstance(v, dict):
                for key, value in v.items():
                    edge_prop.append(f'{str(i)}_{key}' +
                                     ":" + '"' + str(value) + '"')
            else:
                edge_prop.append(str(i) + ":" + '"' + str(v) + '"')
        stmt = "MATCH (inV {}), (outV {}) CREATE (outV)-[:{} {}]->(inV)".format(
            conInV, conOutV, edge_label, "{" + ",".join(edge_prop) + "}")
        return [stmt]
    else:
        stmts = []
        for inV in properties['inVs']:
            conInV = '{{id: "{}"}}'.format(inV)
            conOutV = '{{id: "{}"}}'.format(properties['outV'])
            edge_label = label.split("/")[-1]
            edge_prop = []
            for i, v in properties.items():
                if isinstance(v, dict):
                    continue
                elif isinstance(v, list):
                    continue
                edge_prop.append(str(i) + ":" + '"' + str(v) + '"')
            stmt = "MATCH (inV {}), (outV {}) CREATE (outV)-[:{} {}]->(inV)".format(
                conInV, conOutV, edge_label, "{" + ",".join(edge_prop) + "}")
            stmts.append(stmt)
        return stmts


def l2c(lsif_stmt):
    vertex = []
    edge = []
    for d in lsif_stmt:
        if d['type'] == "vertex" and d['label'] != "hoverResult":
            vertex.append(vertex_stmt(d['label'], d))
        elif d['type'] == "edge":
            edge.extend(edge_stmt(d['label'], d))
    return vertex, edge


@cli.command()
@click.option('--input', default='dump.lsif', prompt='input file')
@click.option('--output', default='total.cypherl', prompt='output file')
def lsif2cypher(input, output):
    with open(input, "r") as f:
        data = [json.loads(line) for line in f]
        data = [d for d in data]
        vertex, edge = l2c(data)
    with open(output, 'w') as fi:
        for i in vertex:
            fi.write(i + "\n")
        fi.write("CREATE INDEX ON :definitionResult(id)\n")
        fi.write("CREATE INDEX ON :document(id)\n")
        fi.write("CREATE INDEX ON :implementationReuslt(id)\n")
        fi.write("CREATE INDEX ON :range(id)\n")
        fi.write("CREATE INDEX ON :referenceResult(id)\n")
        fi.write("CREATE INDEX ON :resultSet(id)\n")
        for i in edge:
            fi.write(i + "\n")


if __name__ == "__main__":
    cli()
