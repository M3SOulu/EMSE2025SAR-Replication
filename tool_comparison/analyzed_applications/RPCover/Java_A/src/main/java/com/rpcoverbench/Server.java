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

  static class Java_AImpl extends Java_AGrpc.Java_AImplBase {
    int cnt = 0;

    @Override
    public void javaA1(
        Message.CommonMessage request,
        io.grpc.stub.StreamObserver<Message.CommonMessage> responseObserver) {
      cnt++;
      Message.CommonMessage response = Message.CommonMessage.newBuilder()
          .mergeFrom(request)
          .setMyString("Java_A_1")
          .build();
      Message.CommonMessage new_request = Message.CommonMessage.newBuilder().mergeFrom(response).build();

      if (cnt > 1000) {
        int choice = rand();
        if (choice % 100 == 0) {
          throw new RuntimeException("fail");
        }
      }

      try {
        javaA2(new_request, responseObserver);
        javaA3(new_request, responseObserver);

        {
          ManagedChannel channel = Grpc.newChannelBuilder("java_c:8080",
              InsecureChannelCredentials.create())
              .build();
          Java_CGrpc.Java_CBlockingStub blockingStub = Java_CGrpc.newBlockingStub(channel);
          blockingStub.javaC1(new_request);
        }

      } catch (Exception e) {
        return;
      }

      response = Message.CommonMessage.newBuilder().mergeFrom(response).addCallStack("Java_A_1").build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      return;
    }

    @Override
    public void javaA2(
        Message.CommonMessage request,
        io.grpc.stub.StreamObserver<Message.CommonMessage> responseObserver) {
      cnt++;
      Message.CommonMessage response = Message.CommonMessage.newBuilder()
          .mergeFrom(request)
          .setMyString("Java_A_2")
          .build();
      Message.CommonMessage new_request = Message.CommonMessage.newBuilder().mergeFrom(response).build();

      if (cnt > 1000) {
        int choice = rand();
        if (choice % 100 == 0) {
          throw new RuntimeException("fail");
        }
      }

      try {
        javaA3(new_request, responseObserver);

        {
          ManagedChannel channel = Grpc.newChannelBuilder("java_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Java_BGrpc.Java_BBlockingStub blockingStub = Java_BGrpc.newBlockingStub(channel);
          blockingStub.javaB1(new_request);
        }

        {
          ManagedChannel channel = Grpc.newChannelBuilder("java_b:8080",
              InsecureChannelCredentials.create())
              .build();
          Java_BGrpc.Java_BBlockingStub blockingStub = Java_BGrpc.newBlockingStub(channel);
          blockingStub.javaB2(new_request);
        }

      } catch (Exception e) {
        return;
      }

      response = Message.CommonMessage.newBuilder().mergeFrom(response).addCallStack("Java_A_2").build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      return;
    }

    @Override
  public void javaA3(
      Message.CommonMessage request,
      io.grpc.stub.StreamObserver<Message.CommonMessage> responseObserver) {
    cnt++;
    Message.CommonMessage response = Message.CommonMessage.newBuilder()
        .mergeFrom(request)
        .setMyString("Java_A_3")
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
        ManagedChannel channel = Grpc.newChannelBuilder("java_b:8080",
            InsecureChannelCredentials.create())
            .build();
        Java_BGrpc.Java_BBlockingStub blockingStub = Java_BGrpc.newBlockingStub(channel);
        blockingStub.javaB2(new_request);
      }

      {
        ManagedChannel channel = Grpc.newChannelBuilder("java_b:8080",
            InsecureChannelCredentials.create())
            .build();
        Java_BGrpc.Java_BBlockingStub blockingStub = Java_BGrpc.newBlockingStub(channel);
        blockingStub.javaB3(new_request);
      }

      {
        ManagedChannel channel = Grpc.newChannelBuilder("ts_a:8080",
            InsecureChannelCredentials.create())
            .build();
        Ts_AGrpc.Ts_ABlockingStub blockingStub = Ts_AGrpc.newBlockingStub(channel);
        blockingStub.tsA1(new_request);
      }

      {
        ManagedChannel channel = Grpc.newChannelBuilder("go_a:8080",
            InsecureChannelCredentials.create())
            .build();
        Go_AGrpc.Go_ABlockingStub blockingStub = Go_AGrpc.newBlockingStub(channel);
        blockingStub.goA1(new_request);
      }

      {
        ManagedChannel channel = Grpc.newChannelBuilder("cpp_a:8080",
            InsecureChannelCredentials.create())
            .build();
        Cpp_AGrpc.Cpp_ABlockingStub blockingStub = Cpp_AGrpc.newBlockingStub(channel);
        blockingStub.cppA1(new_request);
      }

    } catch (Exception e) {
      return;
    }

    response = Message.CommonMessage.newBuilder().mergeFrom(response).addCallStack("Java_A_3").build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
    return;
  }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    int port = 8080;
    io.grpc.Server server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
        .addService(new Java_AImpl())
        .build()
        .start();
    server.awaitTermination();
  }
}
