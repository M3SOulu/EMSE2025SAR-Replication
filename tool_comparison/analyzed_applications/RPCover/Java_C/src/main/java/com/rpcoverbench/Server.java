package com.rpcoverbench;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.InsecureServerCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Random;

public class Server {
  private static int rand() {
    int min = 1;
    int max = 100;

    Random random = new Random();
    int randomNumber = random.nextInt(max - min + 1) + min;

    return randomNumber;
  }

  static class Java_CImpl extends Java_CGrpc.Java_CImplBase {
    int cnt = 0;

    @Override
    public void javaC1(
        Message.CommonMessage request,
        io.grpc.stub.StreamObserver<Message.CommonMessage> responseObserver) {
      cnt++;
      Message.CommonMessage response = Message.CommonMessage.newBuilder()
          .mergeFrom(request)
          .setMyString("Java_C_1")
          .build();
      Message.CommonMessage new_request = Message.CommonMessage.newBuilder().mergeFrom(response).build();

      if (cnt > 1000) {
        int choice = rand();
        if (choice % 100 == 0) {
          throw new RuntimeException("fail");
        }
      }

      try {
        javaC2(new_request, responseObserver);
        javaC3(new_request, responseObserver);

        {
          ManagedChannel channel = Grpc.newChannelBuilder("ts_a:8080",
              InsecureChannelCredentials.create())
              .build();
          Ts_AGrpc.Ts_ABlockingStub blockingStub = Ts_AGrpc.newBlockingStub(channel);
          blockingStub.tsA3(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("ts_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Ts_BGrpc.Ts_BBlockingStub blockingStub = Ts_BGrpc.newBlockingStub(channel);
          blockingStub.tsB2(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("go_a:8080",
              InsecureChannelCredentials.create())
              .build();
          Go_AGrpc.Go_ABlockingStub blockingStub = Go_AGrpc.newBlockingStub(channel);
          blockingStub.goA3(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("go_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Go_BGrpc.Go_BBlockingStub blockingStub = Go_BGrpc.newBlockingStub(channel);
          blockingStub.goB2(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("cpp_a:8080",
              InsecureChannelCredentials.create())
              .build();
          Cpp_AGrpc.Cpp_ABlockingStub blockingStub = Cpp_AGrpc.newBlockingStub(channel);
          blockingStub.cppA3(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("cpp_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Cpp_BGrpc.Cpp_BBlockingStub blockingStub = Cpp_BGrpc.newBlockingStub(channel);
          blockingStub.cppB3(new_request);
        }

      } catch (Exception e) {
        return;
      }

      response = Message.CommonMessage.newBuilder().mergeFrom(response).addCallStack("Java_C_1").build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      return;
    }

    @Override
    public void javaC2(
        Message.CommonMessage request,
        io.grpc.stub.StreamObserver<Message.CommonMessage> responseObserver) {
      cnt++;
      Message.CommonMessage response = Message.CommonMessage.newBuilder()
          .mergeFrom(request)
          .setMyString("Java_C_2")
          .build();
      Message.CommonMessage new_request = Message.CommonMessage.newBuilder().mergeFrom(response).build();

      if (cnt > 1000) {
        int choice = rand();
        if (choice % 100 == 0) {
          throw new RuntimeException("fail");
        }
      }

      try {
        javaC3(new_request, responseObserver);

        {
          ManagedChannel channel = Grpc.newChannelBuilder("ts_c:8080",
              InsecureChannelCredentials.create())
              .build();
          Ts_CGrpc.Ts_CBlockingStub blockingStub = Ts_CGrpc.newBlockingStub(channel);
          blockingStub.tsC2(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("ts_c:8080",
              InsecureChannelCredentials.create())
              .build();
          Ts_CGrpc.Ts_CBlockingStub blockingStub = Ts_CGrpc.newBlockingStub(channel);
          blockingStub.tsC3(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("ts_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Ts_BGrpc.Ts_BBlockingStub blockingStub = Ts_BGrpc.newBlockingStub(channel);
          blockingStub.tsB3(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("go_a:8080",
              InsecureChannelCredentials.create())
              .build();
          Go_AGrpc.Go_ABlockingStub blockingStub = Go_AGrpc.newBlockingStub(channel);
          blockingStub.goA2(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("go_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Go_BGrpc.Go_BBlockingStub blockingStub = Go_BGrpc.newBlockingStub(channel);
          blockingStub.goB3(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("cpp_a:8080",
              InsecureChannelCredentials.create())
              .build();
          Cpp_AGrpc.Cpp_ABlockingStub blockingStub = Cpp_AGrpc.newBlockingStub(channel);
          blockingStub.cppA2(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("cpp_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Cpp_BGrpc.Cpp_BBlockingStub blockingStub = Cpp_BGrpc.newBlockingStub(channel);
          blockingStub.cppB2(new_request);
        }

      } catch (Exception e) {
        return;
      }

      response = Message.CommonMessage.newBuilder().mergeFrom(response).addCallStack("Java_C_2").build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      return;
    }

    @Override
    public void javaC3(
        Message.CommonMessage request,
        io.grpc.stub.StreamObserver<Message.CommonMessage> responseObserver) {
      cnt++;
      Message.CommonMessage response = Message.CommonMessage.newBuilder()
          .mergeFrom(request)
          .setMyString("Java_C_3")
          .build();
      Message.CommonMessage new_request = Message.CommonMessage.newBuilder().mergeFrom(response).build();

      if (cnt > 1000) {
        int choice = rand();
        if (choice % 100 == 0) {
          throw new RuntimeException("fail");
        }
      }

      try {

        {
          ManagedChannel channel = Grpc.newChannelBuilder("ts_c:8080",
              InsecureChannelCredentials.create())
              .build();
          Ts_CGrpc.Ts_CBlockingStub blockingStub = Ts_CGrpc.newBlockingStub(channel);
          blockingStub.tsC2(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("ts_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Ts_BGrpc.Ts_BBlockingStub blockingStub = Ts_BGrpc.newBlockingStub(channel);
          blockingStub.tsB1(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("go_c:8080",
              InsecureChannelCredentials.create())
              .build();
          Go_CGrpc.Go_CBlockingStub blockingStub = Go_CGrpc.newBlockingStub(channel);
          blockingStub.goC2(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("go_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Go_BGrpc.Go_BBlockingStub blockingStub = Go_BGrpc.newBlockingStub(channel);
          blockingStub.goB1(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("cpp_a:8080",
              InsecureChannelCredentials.create())
              .build();
          Cpp_AGrpc.Cpp_ABlockingStub blockingStub = Cpp_AGrpc.newBlockingStub(channel);
          blockingStub.cppA1(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("cpp_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Cpp_BGrpc.Cpp_BBlockingStub blockingStub = Cpp_BGrpc.newBlockingStub(channel);
          blockingStub.cppB1(new_request);
        }

      } catch (Exception e) {
        return;
      }

      response = Message.CommonMessage.newBuilder().mergeFrom(response).addCallStack("Java_C_3").build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      return;
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    int port = 8080;
    io.grpc.Server server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
        .addService(new Java_CImpl())
        .build()
        .start();
    server.awaitTermination();
  }
}
