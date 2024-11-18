load("@rules_proto_grpc//cpp:defs.bzl", "cpp_grpc_library")
load("@rules_proto_grpc//java:defs.bzl", "java_grpc_library")

proto_library(
    name = "benchmark_proto",
    srcs = glob(["*.proto"]),
    visibility = ["//visibility:public"],
    deps = [
        "@com_google_protobuf//:any_proto",
        "@com_google_protobuf//:duration_proto",
        "@com_google_protobuf//:timestamp_proto",
    ],
)

java_grpc_library(
    name = "java_grpc",
    protos = [":benchmark_proto"],
    visibility = ["//visibility:public"],
)

cpp_grpc_library(
    name = "cc_grpc",
    protos = [":benchmark_proto"],
    visibility = ["//visibility:public"],
)
