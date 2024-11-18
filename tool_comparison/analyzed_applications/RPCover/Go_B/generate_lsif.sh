#!/bin/bash

PREV_DIR=$(pwd)
CASE_DIR=$(readlink -f $(dirname "$0"))
ROOT_DIR=$CASE_DIR/..
LSIF_GO_BIN=$ROOT_DIR/third_party/binaries/lsif-go

cd $CASE_DIR

$LSIF_GO_BIN

cd $PREV_DIR
