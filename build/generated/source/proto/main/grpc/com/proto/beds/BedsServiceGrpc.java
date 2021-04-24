package com.proto.beds;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Bidirectional Streaming API
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: beds/beds.proto")
public final class BedsServiceGrpc {

  private BedsServiceGrpc() {}

  public static final String SERVICE_NAME = "beds.BedsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.beds.BedsAvailableRequest,
      com.proto.beds.BedsAvailableResponse> getBedsAvailableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BedsAvailable",
      requestType = com.proto.beds.BedsAvailableRequest.class,
      responseType = com.proto.beds.BedsAvailableResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.beds.BedsAvailableRequest,
      com.proto.beds.BedsAvailableResponse> getBedsAvailableMethod() {
    io.grpc.MethodDescriptor<com.proto.beds.BedsAvailableRequest, com.proto.beds.BedsAvailableResponse> getBedsAvailableMethod;
    if ((getBedsAvailableMethod = BedsServiceGrpc.getBedsAvailableMethod) == null) {
      synchronized (BedsServiceGrpc.class) {
        if ((getBedsAvailableMethod = BedsServiceGrpc.getBedsAvailableMethod) == null) {
          BedsServiceGrpc.getBedsAvailableMethod = getBedsAvailableMethod =
              io.grpc.MethodDescriptor.<com.proto.beds.BedsAvailableRequest, com.proto.beds.BedsAvailableResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BedsAvailable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.beds.BedsAvailableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.beds.BedsAvailableResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BedsServiceMethodDescriptorSupplier("BedsAvailable"))
              .build();
        }
      }
    }
    return getBedsAvailableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.beds.BedsMessageRequest,
      com.proto.beds.BedsMessageResponse> getBedsMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BedsMessage",
      requestType = com.proto.beds.BedsMessageRequest.class,
      responseType = com.proto.beds.BedsMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.beds.BedsMessageRequest,
      com.proto.beds.BedsMessageResponse> getBedsMessageMethod() {
    io.grpc.MethodDescriptor<com.proto.beds.BedsMessageRequest, com.proto.beds.BedsMessageResponse> getBedsMessageMethod;
    if ((getBedsMessageMethod = BedsServiceGrpc.getBedsMessageMethod) == null) {
      synchronized (BedsServiceGrpc.class) {
        if ((getBedsMessageMethod = BedsServiceGrpc.getBedsMessageMethod) == null) {
          BedsServiceGrpc.getBedsMessageMethod = getBedsMessageMethod =
              io.grpc.MethodDescriptor.<com.proto.beds.BedsMessageRequest, com.proto.beds.BedsMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BedsMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.beds.BedsMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.beds.BedsMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BedsServiceMethodDescriptorSupplier("BedsMessage"))
              .build();
        }
      }
    }
    return getBedsMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BedsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BedsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BedsServiceStub>() {
        @java.lang.Override
        public BedsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BedsServiceStub(channel, callOptions);
        }
      };
    return BedsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BedsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BedsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BedsServiceBlockingStub>() {
        @java.lang.Override
        public BedsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BedsServiceBlockingStub(channel, callOptions);
        }
      };
    return BedsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BedsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BedsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BedsServiceFutureStub>() {
        @java.lang.Override
        public BedsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BedsServiceFutureStub(channel, callOptions);
        }
      };
    return BedsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Bidirectional Streaming API
   * </pre>
   */
  public static abstract class BedsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.beds.BedsAvailableRequest> bedsAvailable(
        io.grpc.stub.StreamObserver<com.proto.beds.BedsAvailableResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBedsAvailableMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional Streaming API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.beds.BedsMessageRequest> bedsMessage(
        io.grpc.stub.StreamObserver<com.proto.beds.BedsMessageResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBedsMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBedsAvailableMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.beds.BedsAvailableRequest,
                com.proto.beds.BedsAvailableResponse>(
                  this, METHODID_BEDS_AVAILABLE)))
          .addMethod(
            getBedsMessageMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.beds.BedsMessageRequest,
                com.proto.beds.BedsMessageResponse>(
                  this, METHODID_BEDS_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * Bidirectional Streaming API
   * </pre>
   */
  public static final class BedsServiceStub extends io.grpc.stub.AbstractAsyncStub<BedsServiceStub> {
    private BedsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BedsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BedsServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.beds.BedsAvailableRequest> bedsAvailable(
        io.grpc.stub.StreamObserver<com.proto.beds.BedsAvailableResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBedsAvailableMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional Streaming API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.beds.BedsMessageRequest> bedsMessage(
        io.grpc.stub.StreamObserver<com.proto.beds.BedsMessageResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBedsMessageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Bidirectional Streaming API
   * </pre>
   */
  public static final class BedsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BedsServiceBlockingStub> {
    private BedsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BedsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BedsServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Bidirectional Streaming API
   * </pre>
   */
  public static final class BedsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BedsServiceFutureStub> {
    private BedsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BedsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BedsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_BEDS_AVAILABLE = 0;
  private static final int METHODID_BEDS_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BedsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BedsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BEDS_AVAILABLE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bedsAvailable(
              (io.grpc.stub.StreamObserver<com.proto.beds.BedsAvailableResponse>) responseObserver);
        case METHODID_BEDS_MESSAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bedsMessage(
              (io.grpc.stub.StreamObserver<com.proto.beds.BedsMessageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BedsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BedsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.beds.Beds.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BedsService");
    }
  }

  private static final class BedsServiceFileDescriptorSupplier
      extends BedsServiceBaseDescriptorSupplier {
    BedsServiceFileDescriptorSupplier() {}
  }

  private static final class BedsServiceMethodDescriptorSupplier
      extends BedsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BedsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BedsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BedsServiceFileDescriptorSupplier())
              .addMethod(getBedsAvailableMethod())
              .addMethod(getBedsMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
