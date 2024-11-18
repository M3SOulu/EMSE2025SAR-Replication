package com.rpcoverbench;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: protos/Go_B.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Go_BGrpc {

  private Go_BGrpc() {}

  public static final String SERVICE_NAME = "protos.Go_B";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoB1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Go_B_1",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoB1Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getGoB1Method;
    if ((getGoB1Method = Go_BGrpc.getGoB1Method) == null) {
      synchronized (Go_BGrpc.class) {
        if ((getGoB1Method = Go_BGrpc.getGoB1Method) == null) {
          Go_BGrpc.getGoB1Method = getGoB1Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Go_B_1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Go_BMethodDescriptorSupplier("Go_B_1"))
              .build();
        }
      }
    }
    return getGoB1Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoB2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Go_B_2",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoB2Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getGoB2Method;
    if ((getGoB2Method = Go_BGrpc.getGoB2Method) == null) {
      synchronized (Go_BGrpc.class) {
        if ((getGoB2Method = Go_BGrpc.getGoB2Method) == null) {
          Go_BGrpc.getGoB2Method = getGoB2Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Go_B_2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Go_BMethodDescriptorSupplier("Go_B_2"))
              .build();
        }
      }
    }
    return getGoB2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoB3Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Go_B_3",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoB3Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getGoB3Method;
    if ((getGoB3Method = Go_BGrpc.getGoB3Method) == null) {
      synchronized (Go_BGrpc.class) {
        if ((getGoB3Method = Go_BGrpc.getGoB3Method) == null) {
          Go_BGrpc.getGoB3Method = getGoB3Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Go_B_3"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Go_BMethodDescriptorSupplier("Go_B_3"))
              .build();
        }
      }
    }
    return getGoB3Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Go_BStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Go_BStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Go_BStub>() {
        @java.lang.Override
        public Go_BStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Go_BStub(channel, callOptions);
        }
      };
    return Go_BStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Go_BBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Go_BBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Go_BBlockingStub>() {
        @java.lang.Override
        public Go_BBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Go_BBlockingStub(channel, callOptions);
        }
      };
    return Go_BBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Go_BFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Go_BFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Go_BFutureStub>() {
        @java.lang.Override
        public Go_BFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Go_BFutureStub(channel, callOptions);
        }
      };
    return Go_BFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Go_BImplBase implements io.grpc.BindableService {

    /**
     */
    public void goB1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGoB1Method(), responseObserver);
    }

    /**
     */
    public void goB2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGoB2Method(), responseObserver);
    }

    /**
     */
    public void goB3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGoB3Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGoB1Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_GO_B_1)))
          .addMethod(
            getGoB2Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_GO_B_2)))
          .addMethod(
            getGoB3Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_GO_B_3)))
          .build();
    }
  }

  /**
   */
  public static final class Go_BStub extends io.grpc.stub.AbstractAsyncStub<Go_BStub> {
    private Go_BStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Go_BStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Go_BStub(channel, callOptions);
    }

    /**
     */
    public void goB1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGoB1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void goB2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGoB2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void goB3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGoB3Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Go_BBlockingStub extends io.grpc.stub.AbstractBlockingStub<Go_BBlockingStub> {
    private Go_BBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Go_BBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Go_BBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage goB1(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGoB1Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage goB2(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGoB2Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage goB3(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGoB3Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Go_BFutureStub extends io.grpc.stub.AbstractFutureStub<Go_BFutureStub> {
    private Go_BFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Go_BFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Go_BFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> goB1(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGoB1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> goB2(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGoB2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> goB3(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGoB3Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GO_B_1 = 0;
  private static final int METHODID_GO_B_2 = 1;
  private static final int METHODID_GO_B_3 = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Go_BImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Go_BImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GO_B_1:
          serviceImpl.goB1((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_GO_B_2:
          serviceImpl.goB2((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_GO_B_3:
          serviceImpl.goB3((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Go_BBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Go_BBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpcoverbench.GoB.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Go_B");
    }
  }

  private static final class Go_BFileDescriptorSupplier
      extends Go_BBaseDescriptorSupplier {
    Go_BFileDescriptorSupplier() {}
  }

  private static final class Go_BMethodDescriptorSupplier
      extends Go_BBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Go_BMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (Go_BGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Go_BFileDescriptorSupplier())
              .addMethod(getGoB1Method())
              .addMethod(getGoB2Method())
              .addMethod(getGoB3Method())
              .build();
        }
      }
    }
    return result;
  }
}
