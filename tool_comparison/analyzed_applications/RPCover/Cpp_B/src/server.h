#include "protos/Cpp_B.grpc.pb.h"
#include "protos/Cpp_A.pb.h"
#include <cstdint>
#include <grpc/grpc.h>
#include <grpcpp/server.h>
#include <stdint.h>

using namespace protos;

class CppBImpl final : public ::Cpp_B::Service {
public:
  ::grpc::Status Cpp_B_1(::grpc::ServerContext *context,
                         const ::protos::CommonMessage *request,
                         ::protos::CommonMessage *response);
  ::grpc::Status Cpp_B_2(::grpc::ServerContext *context,
                         const ::protos::CommonMessage *request,
                         ::protos::CommonMessage *response);
  ::grpc::Status Cpp_B_3(::grpc::ServerContext *context,
                         const ::protos::CommonMessage *request,
                         ::protos::CommonMessage *response);

private:
  uint32_t cnt = 0;

  uint32_t rand();
};
