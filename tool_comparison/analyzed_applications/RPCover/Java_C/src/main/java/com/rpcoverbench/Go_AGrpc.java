package com.rpcoverbench;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: protos/Go_A.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Go_AGrpc {

  private Go_AGrpc() {}

  public static final String SERVICE_NAME = "protos.Go_A";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoA1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Go_A_1",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoA1Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getGoA1Method;
    if ((getGoA1Method = Go_AGrpc.getGoA1Method) == null) {
      synchronized (Go_AGrpc.class) {
        if ((getGoA1Method = Go_AGrpc.getGoA1Method) == null) {
          Go_AGrpc.getGoA1Method = getGoA1Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Go_A_1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Go_AMethodDescriptorSupplier("Go_A_1"))
              .build();
        }
      }
    }
    return getGoA1Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoA2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Go_A_2",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoA2Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getGoA2Method;
    if ((getGoA2Method = Go_AGrpc.getGoA2Method) == null) {
      synchronized (Go_AGrpc.class) {
        if ((getGoA2Method = Go_AGrpc.getGoA2Method) == null) {
          Go_AGrpc.getGoA2Method = getGoA2Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Go_A_2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Go_AMethodDescriptorSupplier("Go_A_2"))
              .build();
        }
      }
    }
    return getGoA2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoA3Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Go_A_3",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getGoA3Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getGoA3Method;
    if ((getGoA3Method = Go_AGrpc.getGoA3Method) == null) {
      synchronized (Go_AGrpc.class) {
        if ((getGoA3Method = Go_AGrpc.getGoA3Method) == null) {
          Go_AGrpc.getGoA3Method = getGoA3Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Go_A_3"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Go_AMethodDescriptorSupplier("Go_A_3"))
              .build();
        }
      }
    }
    return getGoA3Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Go_AStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Go_AStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Go_AStub>() {
        @java.lang.Override
        public Go_AStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Go_AStub(channel, callOptions);
        }
      };
    return Go_AStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Go_ABlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Go_ABlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Go_ABlockingStub>() {
        @java.lang.Override
        public Go_ABlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Go_ABlockingStub(channel, callOptions);
        }
      };
    return Go_ABlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Go_AFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Go_AFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Go_AFutureStub>() {
        @java.lang.Override
        public Go_AFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Go_AFutureStub(channel, callOptions);
        }
      };
    return Go_AFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Go_AImplBase implements io.grpc.BindableService {

    /**
     */
    public void goA1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGoA1Method(), responseObserver);
    }

    /**
     */
    public void goA2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGoA2Method(), responseObserver);
    }

    /**
     */
    public void goA3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGoA3Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGoA1Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_GO_A_1)))
          .addMethod(
            getGoA2Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_GO_A_2)))
          .addMethod(
            getGoA3Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_GO_A_3)))
          .build();
    }
  }

  /**
   */
  public static final class Go_AStub extends io.grpc.stub.AbstractAsyncStub<Go_AStub> {
    private Go_AStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Go_AStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Go_AStub(channel, callOptions);
    }

    /**
     */
    public void goA1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGoA1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void goA2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGoA2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void goA3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGoA3Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Go_ABlockingStub extends io.grpc.stub.AbstractBlockingStub<Go_ABlockingStub> {
    private Go_ABlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Go_ABlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Go_ABlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage goA1(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGoA1Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage goA2(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGoA2Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage goA3(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGoA3Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Go_AFutureStub extends io.grpc.stub.AbstractFutureStub<Go_AFutureStub> {
    private Go_AFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Go_AFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Go_AFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> goA1(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGoA1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> goA2(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGoA2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> goA3(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGoA3Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GO_A_1 = 0;
  private static final int METHODID_GO_A_2 = 1;
  private static final int METHODID_GO_A_3 = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Go_AImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Go_AImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GO_A_1:
          serviceImpl.goA1((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_GO_A_2:
          serviceImpl.goA2((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_GO_A_3:
          serviceImpl.goA3((com.rpcoverbench.Message.CommonMessage) request,
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

  private static abstract class Go_ABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Go_ABaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpcoverbench.GoA.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Go_A");
    }
  }

  private static final class Go_AFileDescriptorSupplier
      extends Go_ABaseDescriptorSupplier {
    Go_AFileDescriptorSupplier() {}
  }

  private static final class Go_AMethodDescriptorSupplier
      extends Go_ABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Go_AMethodDescriptorSupplier(String methodName) {
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
      synchronized (Go_AGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Go_AFileDescriptorSupplier())
              .addMethod(getGoA1Method())
              .addMethod(getGoA2Method())
              .addMethod(getGoA3Method())
              .build();
        }
      }
    }
    return result;
  }
}
