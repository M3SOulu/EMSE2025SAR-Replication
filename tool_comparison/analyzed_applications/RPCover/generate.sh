#!/bin/bash

PROTOC_GEN_GO=$(which protoc-gen-go)
PROTOC_GEN_GO_GRPC=$(which protoc-gen-go-grpc)
PROTOC_GEN_PY_GRPC=$(which grpc_python_plugin)
PROTOC_GEN_CPP_GRPC=$(which grpc_cpp_plugin)
PROTOC_GEN_JAVA_GRPC=$(which grpc_java_plugin)
PROTO_DIR=protos
GO_OUT_DIRS=(Go_A Go_B Go_C Cpp_A Cpp_B Cpp_C Java_A Java_B Java_C Ts_A Ts_B Ts_C Python_A Python_B Python_C message)
TS_FOLDER=(Ts_A Ts_B Ts_C)
GO_FOLDER=(Go_A Go_B Go_C)
PYTHON_FOLDER=(Python_A Python_B Python_C)
JAVA_FOLDER=(Java_A/src/main/java Java_B/src/main/java Java_C/src/main/java)
CPP_FOLDER=(Cpp_A Cpp_B Cpp_C)

for file in "${GO_FOLDER[@]}"; do
  for dir in "${GO_OUT_DIRS[@]}"; do
    if [ ! -d "$dir" ]; then
      mkdir "$dir"
    fi
    protoc --go_out=$file --go-grpc_out=$file --plugin=protoc-gen-go=$PROTOC_GEN_GO --lsif_out=$file --plugin=./protoc-gen-lsif --lsif_opt=grpc_file=$file/proto/"$dir"_grpc.pb.go --plugin=protoc-gen-go-grpc=$PROTOC_GEN_GO_GRPC $PROTO_DIR/"$dir".proto
  done
done

for file in "${PYTHON_FOLDER[@]}"; do
  for dir in "${GO_OUT_DIRS[@]}"; do
    if [ ! -d "$dir" ]; then
      mkdir "$dir"
    fi
    protoc --python_out=$file --python-grpc_out=$file --pyi_out=$file --plugin=protoc-gen-python-grpc=$PROTOC_GEN_PY_GRPC $PROTO_DIR/"$dir".proto
    # protoc --python_out=$file --python-grpc_out=$file --pyi_out=$file --plugin=protoc-gen-python-grpc=$PROTOC_GEN_PY_GRPC --lsif_out=$file --plugin=./protoc-gen-lsif --lsif_opt=grpc_file=$file/protos/"$dir"_pb2_grpc.py $PROTO_DIR/"$dir".proto
  done
done

for file in "${TS_FOLDER[@]}"; do
  for dir in "${GO_OUT_DIRS[@]}"; do
    if [ ! -d "$dir" ]; then
      mkdir "$dir"
    fi
    # npx grpc_tools_node_protoc --ts_out=$file --js_out=import_style=commonjs,binary:$file --grpc_out="grpc_js:$file" --plugin=protoc-gen-grpc=$PROTOC_GEN_NODE_GRPC -I ./ $PROTO_DIR/"$dir".proto
    # protoc --python_out=$file --python-grpc_out=$file --pyi_out=$file --plugin=protoc-gen-python-grpc=$PROTOC_GEN_PY_GRPC --lsif_out=$file --plugin=./protoc-gen-lsif --lsif_opt=grpc_file=$file/protos/"$dir"_pb2_grpc.py $PROTO_DIR/"$dir".proto
    protoc --plugin=$(npm root)/.bin/protoc-gen-ts_proto \
      --ts_proto_out=$file \
      --ts_proto_opt=outputServices=grpc-js \
      --ts_proto_opt=esModuleInterop=true \
      -I=./ protos/"$dir".proto
  done
done

for file in "${JAVA_FOLDER[@]}"; do
  for dir in "${GO_OUT_DIRS[@]}"; do
    if [ ! -d "$dir" ]; then
      mkdir "$dir"
    fi
    protoc --java_out=$file --java-grpc_out=$file --plugin=protoc-gen-java-grpc=$PROTOC_GEN_JAVA_GRPC $PROTO_DIR/"$dir".proto
  done
done

for file in "${CPP_FOLDER[@]}"; do
  for dir in "${GO_OUT_DIRS[@]}"; do
    if [ ! -d "$dir" ]; then
      mkdir "$dir"
    fi
    protoc --cpp_out=$file --cpp-grpc_out=$file --plugin=protoc-gen-cpp-grpc=$PROTOC_GEN_CPP_GRPC $PROTO_DIR/"$dir".proto
  done
done
