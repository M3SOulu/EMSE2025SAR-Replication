#!/bin/bash

PREV_DIR=$(pwd)
CASE_DIR=$(readlink -f $(dirname "$0"))
ROOT_DIR=$CASE_DIR/..
LSIF_PY_BIN=$ROOT_DIR/third_party/lsif-py/lsif-py

cd $CASE_DIR

$LSIF_PY_BIN ./

cd $PREV_DIR
