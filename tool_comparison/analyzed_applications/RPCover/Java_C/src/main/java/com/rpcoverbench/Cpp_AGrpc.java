package com.rpcoverbench;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: protos/Cpp_A.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Cpp_AGrpc {

  private Cpp_AGrpc() {}

  public static final String SERVICE_NAME = "protos.Cpp_A";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppA1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cpp_A_1",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppA1Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getCppA1Method;
    if ((getCppA1Method = Cpp_AGrpc.getCppA1Method) == null) {
      synchronized (Cpp_AGrpc.class) {
        if ((getCppA1Method = Cpp_AGrpc.getCppA1Method) == null) {
          Cpp_AGrpc.getCppA1Method = getCppA1Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cpp_A_1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Cpp_AMethodDescriptorSupplier("Cpp_A_1"))
              .build();
        }
      }
    }
    return getCppA1Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppA2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cpp_A_2",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppA2Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getCppA2Method;
    if ((getCppA2Method = Cpp_AGrpc.getCppA2Method) == null) {
      synchronized (Cpp_AGrpc.class) {
        if ((getCppA2Method = Cpp_AGrpc.getCppA2Method) == null) {
          Cpp_AGrpc.getCppA2Method = getCppA2Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cpp_A_2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Cpp_AMethodDescriptorSupplier("Cpp_A_2"))
              .build();
        }
      }
    }
    return getCppA2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppA3Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cpp_A_3",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppA3Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getCppA3Method;
    if ((getCppA3Method = Cpp_AGrpc.getCppA3Method) == null) {
      synchronized (Cpp_AGrpc.class) {
        if ((getCppA3Method = Cpp_AGrpc.getCppA3Method) == null) {
          Cpp_AGrpc.getCppA3Method = getCppA3Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cpp_A_3"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Cpp_AMethodDescriptorSupplier("Cpp_A_3"))
              .build();
        }
      }
    }
    return getCppA3Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Cpp_AStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Cpp_AStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Cpp_AStub>() {
        @java.lang.Override
        public Cpp_AStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Cpp_AStub(channel, callOptions);
        }
      };
    return Cpp_AStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Cpp_ABlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Cpp_ABlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Cpp_ABlockingStub>() {
        @java.lang.Override
        public Cpp_ABlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Cpp_ABlockingStub(channel, callOptions);
        }
      };
    return Cpp_ABlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Cpp_AFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Cpp_AFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Cpp_AFutureStub>() {
        @java.lang.Override
        public Cpp_AFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Cpp_AFutureStub(channel, callOptions);
        }
      };
    return Cpp_AFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Cpp_AImplBase implements io.grpc.BindableService {

    /**
     */
    public void cppA1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCppA1Method(), responseObserver);
    }

    /**
     */
    public void cppA2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCppA2Method(), responseObserver);
    }

    /**
     */
    public void cppA3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCppA3Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCppA1Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_CPP_A_1)))
          .addMethod(
            getCppA2Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_CPP_A_2)))
          .addMethod(
            getCppA3Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_CPP_A_3)))
          .build();
    }
  }

  /**
   */
  public static final class Cpp_AStub extends io.grpc.stub.AbstractAsyncStub<Cpp_AStub> {
    private Cpp_AStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Cpp_AStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Cpp_AStub(channel, callOptions);
    }

    /**
     */
    public void cppA1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCppA1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cppA2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCppA2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cppA3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCppA3Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Cpp_ABlockingStub extends io.grpc.stub.AbstractBlockingStub<Cpp_ABlockingStub> {
    private Cpp_ABlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Cpp_ABlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Cpp_ABlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage cppA1(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCppA1Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage cppA2(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCppA2Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage cppA3(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCppA3Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Cpp_AFutureStub extends io.grpc.stub.AbstractFutureStub<Cpp_AFutureStub> {
    private Cpp_AFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Cpp_AFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Cpp_AFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> cppA1(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCppA1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> cppA2(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCppA2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> cppA3(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCppA3Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CPP_A_1 = 0;
  private static final int METHODID_CPP_A_2 = 1;
  private static final int METHODID_CPP_A_3 = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Cpp_AImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Cpp_AImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CPP_A_1:
          serviceImpl.cppA1((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_CPP_A_2:
          serviceImpl.cppA2((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_CPP_A_3:
          serviceImpl.cppA3((com.rpcoverbench.Message.CommonMessage) request,
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

  private static abstract class Cpp_ABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Cpp_ABaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpcoverbench.CppA.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Cpp_A");
    }
  }

  private static final class Cpp_AFileDescriptorSupplier
      extends Cpp_ABaseDescriptorSupplier {
    Cpp_AFileDescriptorSupplier() {}
  }

  private static final class Cpp_AMethodDescriptorSupplier
      extends Cpp_ABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Cpp_AMethodDescriptorSupplier(String methodName) {
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
      synchronized (Cpp_AGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Cpp_AFileDescriptorSupplier())
              .addMethod(getCppA1Method())
              .addMethod(getCppA2Method())
              .addMethod(getCppA3Method())
              .build();
        }
      }
    }
    return result;
  }
}
