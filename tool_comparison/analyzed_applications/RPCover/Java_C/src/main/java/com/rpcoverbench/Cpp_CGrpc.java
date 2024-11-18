package com.rpcoverbench;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: protos/Cpp_C.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Cpp_CGrpc {

  private Cpp_CGrpc() {}

  public static final String SERVICE_NAME = "protos.Cpp_C";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppC1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cpp_C_1",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppC1Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getCppC1Method;
    if ((getCppC1Method = Cpp_CGrpc.getCppC1Method) == null) {
      synchronized (Cpp_CGrpc.class) {
        if ((getCppC1Method = Cpp_CGrpc.getCppC1Method) == null) {
          Cpp_CGrpc.getCppC1Method = getCppC1Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cpp_C_1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Cpp_CMethodDescriptorSupplier("Cpp_C_1"))
              .build();
        }
      }
    }
    return getCppC1Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppC2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cpp_C_2",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppC2Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getCppC2Method;
    if ((getCppC2Method = Cpp_CGrpc.getCppC2Method) == null) {
      synchronized (Cpp_CGrpc.class) {
        if ((getCppC2Method = Cpp_CGrpc.getCppC2Method) == null) {
          Cpp_CGrpc.getCppC2Method = getCppC2Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cpp_C_2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Cpp_CMethodDescriptorSupplier("Cpp_C_2"))
              .build();
        }
      }
    }
    return getCppC2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppC3Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cpp_C_3",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getCppC3Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getCppC3Method;
    if ((getCppC3Method = Cpp_CGrpc.getCppC3Method) == null) {
      synchronized (Cpp_CGrpc.class) {
        if ((getCppC3Method = Cpp_CGrpc.getCppC3Method) == null) {
          Cpp_CGrpc.getCppC3Method = getCppC3Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cpp_C_3"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Cpp_CMethodDescriptorSupplier("Cpp_C_3"))
              .build();
        }
      }
    }
    return getCppC3Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Cpp_CStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Cpp_CStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Cpp_CStub>() {
        @java.lang.Override
        public Cpp_CStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Cpp_CStub(channel, callOptions);
        }
      };
    return Cpp_CStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Cpp_CBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Cpp_CBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Cpp_CBlockingStub>() {
        @java.lang.Override
        public Cpp_CBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Cpp_CBlockingStub(channel, callOptions);
        }
      };
    return Cpp_CBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Cpp_CFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Cpp_CFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Cpp_CFutureStub>() {
        @java.lang.Override
        public Cpp_CFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Cpp_CFutureStub(channel, callOptions);
        }
      };
    return Cpp_CFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Cpp_CImplBase implements io.grpc.BindableService {

    /**
     */
    public void cppC1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCppC1Method(), responseObserver);
    }

    /**
     */
    public void cppC2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCppC2Method(), responseObserver);
    }

    /**
     */
    public void cppC3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCppC3Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCppC1Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_CPP_C_1)))
          .addMethod(
            getCppC2Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_CPP_C_2)))
          .addMethod(
            getCppC3Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_CPP_C_3)))
          .build();
    }
  }

  /**
   */
  public static final class Cpp_CStub extends io.grpc.stub.AbstractAsyncStub<Cpp_CStub> {
    private Cpp_CStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Cpp_CStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Cpp_CStub(channel, callOptions);
    }

    /**
     */
    public void cppC1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCppC1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cppC2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCppC2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cppC3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCppC3Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Cpp_CBlockingStub extends io.grpc.stub.AbstractBlockingStub<Cpp_CBlockingStub> {
    private Cpp_CBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Cpp_CBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Cpp_CBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage cppC1(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCppC1Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage cppC2(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCppC2Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage cppC3(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCppC3Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Cpp_CFutureStub extends io.grpc.stub.AbstractFutureStub<Cpp_CFutureStub> {
    private Cpp_CFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Cpp_CFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Cpp_CFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> cppC1(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCppC1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> cppC2(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCppC2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> cppC3(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCppC3Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CPP_C_1 = 0;
  private static final int METHODID_CPP_C_2 = 1;
  private static final int METHODID_CPP_C_3 = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Cpp_CImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Cpp_CImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CPP_C_1:
          serviceImpl.cppC1((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_CPP_C_2:
          serviceImpl.cppC2((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_CPP_C_3:
          serviceImpl.cppC3((com.rpcoverbench.Message.CommonMessage) request,
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

  private static abstract class Cpp_CBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Cpp_CBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpcoverbench.CppC.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Cpp_C");
    }
  }

  private static final class Cpp_CFileDescriptorSupplier
      extends Cpp_CBaseDescriptorSupplier {
    Cpp_CFileDescriptorSupplier() {}
  }

  private static final class Cpp_CMethodDescriptorSupplier
      extends Cpp_CBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Cpp_CMethodDescriptorSupplier(String methodName) {
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
      synchronized (Cpp_CGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Cpp_CFileDescriptorSupplier())
              .addMethod(getCppC1Method())
              .addMethod(getCppC2Method())
              .addMethod(getCppC3Method())
              .build();
        }
      }
    }
    return result;
  }
}
