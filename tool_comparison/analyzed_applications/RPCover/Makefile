protos:
	protoc --go_out=Go_A  --grpc_out=Go_A --plugin=protoc-gen-grpc=/Users/lincyaw/go/bin/protoc-gen-go-grpc protos/Go_A.proto
	protoc --go_out=Go_B  --grpc_out=Go_B --plugin=protoc-gen-grpc=/Users/lincyaw/go/bin/protoc-gen-go-grpc protos/Go_B.proto
	protoc --go_out=Go_C  --grpc_out=Go_C --plugin=protoc-gen-grpc=/Users/lincyaw/go/bin/protoc-gen-go-grpc protos/Go_C.proto

clean:
	# bazel clean
	rm *.scip
	rm *.log

all:
	make -C Cpp_A
	make -C Cpp_B
	make -C Cpp_C

	make -C Java_A
	make -C Java_B
	make -C Java_C

	make -C Go_A
	make -C Go_B
	make -C Go_C

	make -C hotelReservation
