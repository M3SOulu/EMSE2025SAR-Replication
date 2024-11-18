package com.rpcoverbench;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: protos/Python_A.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Python_AGrpc {

  private Python_AGrpc() {}

  public static final String SERVICE_NAME = "protos.Python_A";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getPythonA1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Python_A_1",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getPythonA1Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getPythonA1Method;
    if ((getPythonA1Method = Python_AGrpc.getPythonA1Method) == null) {
      synchronized (Python_AGrpc.class) {
        if ((getPythonA1Method = Python_AGrpc.getPythonA1Method) == null) {
          Python_AGrpc.getPythonA1Method = getPythonA1Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Python_A_1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Python_AMethodDescriptorSupplier("Python_A_1"))
              .build();
        }
      }
    }
    return getPythonA1Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getPythonA2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Python_A_2",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getPythonA2Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getPythonA2Method;
    if ((getPythonA2Method = Python_AGrpc.getPythonA2Method) == null) {
      synchronized (Python_AGrpc.class) {
        if ((getPythonA2Method = Python_AGrpc.getPythonA2Method) == null) {
          Python_AGrpc.getPythonA2Method = getPythonA2Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Python_A_2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Python_AMethodDescriptorSupplier("Python_A_2"))
              .build();
        }
      }
    }
    return getPythonA2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getPythonA3Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Python_A_3",
      requestType = com.rpcoverbench.Message.CommonMessage.class,
      responseType = com.rpcoverbench.Message.CommonMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage,
      com.rpcoverbench.Message.CommonMessage> getPythonA3Method() {
    io.grpc.MethodDescriptor<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage> getPythonA3Method;
    if ((getPythonA3Method = Python_AGrpc.getPythonA3Method) == null) {
      synchronized (Python_AGrpc.class) {
        if ((getPythonA3Method = Python_AGrpc.getPythonA3Method) == null) {
          Python_AGrpc.getPythonA3Method = getPythonA3Method =
              io.grpc.MethodDescriptor.<com.rpcoverbench.Message.CommonMessage, com.rpcoverbench.Message.CommonMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Python_A_3"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcoverbench.Message.CommonMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Python_AMethodDescriptorSupplier("Python_A_3"))
              .build();
        }
      }
    }
    return getPythonA3Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Python_AStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Python_AStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Python_AStub>() {
        @java.lang.Override
        public Python_AStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Python_AStub(channel, callOptions);
        }
      };
    return Python_AStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Python_ABlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Python_ABlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Python_ABlockingStub>() {
        @java.lang.Override
        public Python_ABlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Python_ABlockingStub(channel, callOptions);
        }
      };
    return Python_ABlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Python_AFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Python_AFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Python_AFutureStub>() {
        @java.lang.Override
        public Python_AFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Python_AFutureStub(channel, callOptions);
        }
      };
    return Python_AFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Python_AImplBase implements io.grpc.BindableService {

    /**
     */
    public void pythonA1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPythonA1Method(), responseObserver);
    }

    /**
     */
    public void pythonA2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPythonA2Method(), responseObserver);
    }

    /**
     */
    public void pythonA3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPythonA3Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPythonA1Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_PYTHON_A_1)))
          .addMethod(
            getPythonA2Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_PYTHON_A_2)))
          .addMethod(
            getPythonA3Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rpcoverbench.Message.CommonMessage,
                com.rpcoverbench.Message.CommonMessage>(
                  this, METHODID_PYTHON_A_3)))
          .build();
    }
  }

  /**
   */
  public static final class Python_AStub extends io.grpc.stub.AbstractAsyncStub<Python_AStub> {
    private Python_AStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Python_AStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Python_AStub(channel, callOptions);
    }

    /**
     */
    public void pythonA1(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPythonA1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pythonA2(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPythonA2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pythonA3(com.rpcoverbench.Message.CommonMessage request,
        io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPythonA3Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Python_ABlockingStub extends io.grpc.stub.AbstractBlockingStub<Python_ABlockingStub> {
    private Python_ABlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Python_ABlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Python_ABlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage pythonA1(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPythonA1Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage pythonA2(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPythonA2Method(), getCallOptions(), request);
    }

    /**
     */
    public com.rpcoverbench.Message.CommonMessage pythonA3(com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPythonA3Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Python_AFutureStub extends io.grpc.stub.AbstractFutureStub<Python_AFutureStub> {
    private Python_AFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Python_AFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Python_AFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> pythonA1(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPythonA1Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> pythonA2(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPythonA2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcoverbench.Message.CommonMessage> pythonA3(
        com.rpcoverbench.Message.CommonMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPythonA3Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PYTHON_A_1 = 0;
  private static final int METHODID_PYTHON_A_2 = 1;
  private static final int METHODID_PYTHON_A_3 = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Python_AImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Python_AImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PYTHON_A_1:
          serviceImpl.pythonA1((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_PYTHON_A_2:
          serviceImpl.pythonA2((com.rpcoverbench.Message.CommonMessage) request,
              (io.grpc.stub.StreamObserver<com.rpcoverbench.Message.CommonMessage>) responseObserver);
          break;
        case METHODID_PYTHON_A_3:
          serviceImpl.pythonA3((com.rpcoverbench.Message.CommonMessage) request,
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

  private static abstract class Python_ABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Python_ABaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpcoverbench.PythonA.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Python_A");
    }
  }

  private static final class Python_AFileDescriptorSupplier
      extends Python_ABaseDescriptorSupplier {
    Python_AFileDescriptorSupplier() {}
  }

  private static final class Python_AMethodDescriptorSupplier
      extends Python_ABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Python_AMethodDescriptorSupplier(String methodName) {
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
      synchronized (Python_AGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Python_AFileDescriptorSupplier())
              .addMethod(getPythonA1Method())
              .addMethod(getPythonA2Method())
              .addMethod(getPythonA3Method())
              .build();
        }
      }
    }
    return result;
  }
}
