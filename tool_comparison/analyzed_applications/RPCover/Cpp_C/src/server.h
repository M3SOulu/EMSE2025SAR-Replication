#include "protos/Cpp_C.grpc.pb.h"
#include "protos/Cpp_A.pb.h"
#include <cstdint>
#include <grpc/grpc.h>
#include <grpcpp/server.h>
#include <stdint.h>

using namespace protos;

class CppCImpl final : public ::Cpp_C::Service {
public:
  ::grpc::Status Cpp_C_1(::grpc::ServerContext *context,
                         const ::protos::CommonMessage *request,
                         ::protos::CommonMessage *response);
  ::grpc::Status Cpp_C_2(::grpc::ServerContext *context,
                         const ::protos::CommonMessage *request,
                         ::protos::CommonMessage *response);
  ::grpc::Status Cpp_C_3(::grpc::ServerContext *context,
                         const ::protos::CommonMessage *request,
                         ::protos::CommonMessage *response);

private:
  uint32_t cnt = 0;

  uint32_t rand();
};
