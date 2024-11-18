#include "server.h"
#include "protos/Cpp_B.grpc.pb.h"
#include "protos/Cpp_C.grpc.pb.h"
#include "protos/Java_B.grpc.pb.h"
#include "protos/Python_B.grpc.pb.h"
#include "protos/Ts_A.grpc.pb.h"
#include "protos/Ts_B.grpc.pb.h"
#include "protos/Ts_C.grpc.pb.h"
#include "protos/message.pb.h"
#include <cstdint>
#include <exception>
#include <grpcpp/client_context.h>
#include <grpcpp/create_channel.h>
#include <grpcpp/server_builder.h>
#include <grpcpp/support/status.h>
#include <random>
#include <stdexcept>

u_int32_t CppBImpl::rand() {
  std::random_device rd;
  std::mt19937 gen(rd());

  uint32_t min = 1;
  uint32_t max = 100;

  std::uniform_int_distribution<uint32_t> dist(min, max);

  return dist(gen);
}

::grpc::Status CppBImpl::Cpp_B_1(::grpc::ServerContext *context,
                                 const ::protos::CommonMessage *request,
                                 ::protos::CommonMessage *response) {
  cnt++;
  *response = *request;
  response->set_my_string("Cpp_B_1");
  if (cnt > 1000) {
    uint32_t choice = rand();
    if (choice % 100 == 0) {
      throw std::runtime_error("fail");
    }
  }

  // inner calls
  try {
    ::protos::CommonMessage new_response;
    Cpp_B_3(context, response, &new_response);

    {
      auto ch = ::grpc::CreateChannel("cpp_c:8080",
                                      grpc::InsecureChannelCredentials());
      auto stub = ::Cpp_C::NewStub(ch);
      ::protos::CommonMessage new_response;
      ::grpc::ClientContext new_context;
      ::protos::CommonMessage new_request = *response;
      stub->Cpp_C_1(&new_context, new_request, &new_response);
    }

    {
      auto ch = ::grpc::CreateChannel("cpp_c:8080",
                                      grpc::InsecureChannelCredentials());
      auto stub = ::Cpp_C::NewStub(ch);
      ::protos::CommonMessage new_response;
      ::grpc::ClientContext new_context;
      ::protos::CommonMessage new_request = *response;
      stub->Cpp_C_2(&new_context, new_request, &new_response);
    }

  } catch (std::exception &e) {
    return ::grpc::Status(::grpc::StatusCode::ABORTED, "abort");
  }

  response->add_call_stack("Cpp_B_1");
  return ::grpc::Status::OK;
}

::grpc::Status CppBImpl::Cpp_B_2(::grpc::ServerContext *context,
                                 const ::protos::CommonMessage *request,
                                 ::protos::CommonMessage *response) {
  cnt++;
  *response = *request;
  response->set_my_string("Cpp_B_2");
  if (cnt > 1000) {
    uint32_t choice = rand();
    if (choice % 100 == 0) {
      throw std::runtime_error("fail");
    }
  }

  // inner calls
  try {
    {
      ::protos::CommonMessage new_response;
      Cpp_B_3(context, response, &new_response);
    }

    {
      auto ch = ::grpc::CreateChannel("cpp_c:8080",
                                      grpc::InsecureChannelCredentials());
      auto stub = ::Cpp_C::NewStub(ch);
      ::protos::CommonMessage new_response;
      ::grpc::ClientContext new_context;
      ::protos::CommonMessage new_request = *response;
      stub->Cpp_C_1(&new_context, new_request, &new_response);
    }

    {
      auto ch = ::grpc::CreateChannel("java_b:8080",
                                      grpc::InsecureChannelCredentials());
      auto stub = ::Java_B::NewStub(ch);
      ::protos::CommonMessage new_response;
      ::grpc::ClientContext new_context;
      ::protos::CommonMessage new_request = *response;
      stub->Java_B_2(&new_context, new_request, &new_response);
    }

  } catch (std::exception &e) {
    return ::grpc::Status(::grpc::StatusCode::ABORTED, "abort");
  }

  response->add_call_stack("Cpp_B_2");
  return ::grpc::Status::OK;
}

::grpc::Status CppBImpl::Cpp_B_3(::grpc::ServerContext *context,
                                 const ::protos::CommonMessage *request,
                                 ::protos::CommonMessage *response) {
  cnt++;
  *response = *request;
  response->set_my_string("Cpp_B_3");
  if (cnt > 1000) {
    uint32_t choice = rand();
    if (choice % 100 == 0) {
      throw std::runtime_error("fail");
    }
  }

  // inner calls
  try {

    {
      auto ch = ::grpc::CreateChannel("cpp_c:8080",
                                      grpc::InsecureChannelCredentials());
      auto stub = ::Cpp_C::NewStub(ch);
      ::protos::CommonMessage new_response;
      ::grpc::ClientContext new_context;
      ::protos::CommonMessage new_request = *response;
      stub->Cpp_C_3(&new_context, new_request, &new_response);
    }

    {
      auto ch = ::grpc::CreateChannel("cpp_c:8080",
                                      grpc::InsecureChannelCredentials());
      auto stub = ::Cpp_C::NewStub(ch);
      ::protos::CommonMessage new_response;
      ::grpc::ClientContext new_context;
      ::protos::CommonMessage new_request = *response;
      stub->Cpp_C_2(&new_context, new_request, &new_response);
    }
  } catch (std::exception &e) {
    return ::grpc::Status(::grpc::StatusCode::ABORTED, "abort");
  }

  response->add_call_stack("Cpp_B_3");
  return ::grpc::Status::OK;
}

int main(void) {
  std::string server_address = "0.0.0.0:8080";
  CppBImpl service;

  ::grpc::ServerBuilder builder;

  builder.AddListeningPort(server_address, grpc::InsecureServerCredentials());
  builder.RegisterService(&service);
  std::unique_ptr<::grpc::Server> server(builder.BuildAndStart());
  std::cout << "Server listening on " << server_address << std::endl;

  server->Wait();
}
