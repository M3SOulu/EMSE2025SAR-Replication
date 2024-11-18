#!/bin/bash

PREV_DIR=$(pwd)
CASE_DIR=$(readlink -f $(dirname "$0"))
ROOT_DIR=$CASE_DIR/..
SCIP_JAVA_BIN=$ROOT_DIR/third_party/binaries/scip-java

OUTPUT_DIR=$(readlink -f $1)

cd $CASE_DIR
$SCIP_JAVA_BIN index --build-tool=Maven --output $OUTPUT_DIR
cd $PREV_DIR
