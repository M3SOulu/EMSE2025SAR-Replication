all: build scip

build:
	mvn clean package

scip: build
	./generate_index.sh ./index.scip
