#!/bin/bash

PREV_DIR=$(pwd)
CASE_DIR=$(readlink -f $(dirname "$0"))
ROOT_DIR=$CASE_DIR/..
LSIF_CLANG_BIN=$ROOT_DIR/third_party/lsif-clang-0.1.0/lsif-clang

CC_PATH=$CASE_DIR/build/compile_commands.json

OUTPUT_DIR=$1

cd $CASE_DIR

if [ ! -d "build" ]; then
    echo "build dir not found"
    exit 1
fi

$LSIF_CLANG_BIN --extra-arg="-resource-dir=$(clang -print-resource-dir)" $CC_PATH

cd $PREV_DIR
