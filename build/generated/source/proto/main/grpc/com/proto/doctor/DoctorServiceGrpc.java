package com.proto.doctor;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: doctor/doctor.proto")
public final class DoctorServiceGrpc {

  private DoctorServiceGrpc() {}

  public static final String SERVICE_NAME = "doctor.DoctorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.doctor.DoctorRequest,
      com.proto.doctor.DoctorResponse> getDoctorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Doctor",
      requestType = com.proto.doctor.DoctorRequest.class,
      responseType = com.proto.doctor.DoctorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.doctor.DoctorRequest,
      com.proto.doctor.DoctorResponse> getDoctorMethod() {
    io.grpc.MethodDescriptor<com.proto.doctor.DoctorRequest, com.proto.doctor.DoctorResponse> getDoctorMethod;
    if ((getDoctorMethod = DoctorServiceGrpc.getDoctorMethod) == null) {
      synchronized (DoctorServiceGrpc.class) {
        if ((getDoctorMethod = DoctorServiceGrpc.getDoctorMethod) == null) {
          DoctorServiceGrpc.getDoctorMethod = getDoctorMethod =
              io.grpc.MethodDescriptor.<com.proto.doctor.DoctorRequest, com.proto.doctor.DoctorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Doctor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.doctor.DoctorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.doctor.DoctorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DoctorServiceMethodDescriptorSupplier("Doctor"))
              .build();
        }
      }
    }
    return getDoctorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.doctor.RegisterDoctorRequest,
      com.proto.doctor.RegisterDoctorResponse> getRegisterDoctorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterDoctor",
      requestType = com.proto.doctor.RegisterDoctorRequest.class,
      responseType = com.proto.doctor.RegisterDoctorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.doctor.RegisterDoctorRequest,
      com.proto.doctor.RegisterDoctorResponse> getRegisterDoctorMethod() {
    io.grpc.MethodDescriptor<com.proto.doctor.RegisterDoctorRequest, com.proto.doctor.RegisterDoctorResponse> getRegisterDoctorMethod;
    if ((getRegisterDoctorMethod = DoctorServiceGrpc.getRegisterDoctorMethod) == null) {
      synchronized (DoctorServiceGrpc.class) {
        if ((getRegisterDoctorMethod = DoctorServiceGrpc.getRegisterDoctorMethod) == null) {
          DoctorServiceGrpc.getRegisterDoctorMethod = getRegisterDoctorMethod =
              io.grpc.MethodDescriptor.<com.proto.doctor.RegisterDoctorRequest, com.proto.doctor.RegisterDoctorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterDoctor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.doctor.RegisterDoctorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.doctor.RegisterDoctorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DoctorServiceMethodDescriptorSupplier("RegisterDoctor"))
              .build();
        }
      }
    }
    return getRegisterDoctorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DoctorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DoctorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DoctorServiceStub>() {
        @java.lang.Override
        public DoctorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DoctorServiceStub(channel, callOptions);
        }
      };
    return DoctorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DoctorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DoctorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DoctorServiceBlockingStub>() {
        @java.lang.Override
        public DoctorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DoctorServiceBlockingStub(channel, callOptions);
        }
      };
    return DoctorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DoctorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DoctorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DoctorServiceFutureStub>() {
        @java.lang.Override
        public DoctorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DoctorServiceFutureStub(channel, callOptions);
        }
      };
    return DoctorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DoctorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void doctor(com.proto.doctor.DoctorRequest request,
        io.grpc.stub.StreamObserver<com.proto.doctor.DoctorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDoctorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void registerDoctor(com.proto.doctor.RegisterDoctorRequest request,
        io.grpc.stub.StreamObserver<com.proto.doctor.RegisterDoctorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterDoctorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDoctorMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.doctor.DoctorRequest,
                com.proto.doctor.DoctorResponse>(
                  this, METHODID_DOCTOR)))
          .addMethod(
            getRegisterDoctorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.proto.doctor.RegisterDoctorRequest,
                com.proto.doctor.RegisterDoctorResponse>(
                  this, METHODID_REGISTER_DOCTOR)))
          .build();
    }
  }

  /**
   */
  public static final class DoctorServiceStub extends io.grpc.stub.AbstractAsyncStub<DoctorServiceStub> {
    private DoctorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DoctorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void doctor(com.proto.doctor.DoctorRequest request,
        io.grpc.stub.StreamObserver<com.proto.doctor.DoctorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDoctorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void registerDoctor(com.proto.doctor.RegisterDoctorRequest request,
        io.grpc.stub.StreamObserver<com.proto.doctor.RegisterDoctorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterDoctorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DoctorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DoctorServiceBlockingStub> {
    private DoctorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DoctorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public java.util.Iterator<com.proto.doctor.DoctorResponse> doctor(
        com.proto.doctor.DoctorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDoctorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.proto.doctor.RegisterDoctorResponse registerDoctor(com.proto.doctor.RegisterDoctorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterDoctorMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DoctorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DoctorServiceFutureStub> {
    private DoctorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DoctorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.doctor.RegisterDoctorResponse> registerDoctor(
        com.proto.doctor.RegisterDoctorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterDoctorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DOCTOR = 0;
  private static final int METHODID_REGISTER_DOCTOR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DoctorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DoctorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DOCTOR:
          serviceImpl.doctor((com.proto.doctor.DoctorRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.doctor.DoctorResponse>) responseObserver);
          break;
        case METHODID_REGISTER_DOCTOR:
          serviceImpl.registerDoctor((com.proto.doctor.RegisterDoctorRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.doctor.RegisterDoctorResponse>) responseObserver);
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

  private static abstract class DoctorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DoctorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.doctor.Doctor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DoctorService");
    }
  }

  private static final class DoctorServiceFileDescriptorSupplier
      extends DoctorServiceBaseDescriptorSupplier {
    DoctorServiceFileDescriptorSupplier() {}
  }

  private static final class DoctorServiceMethodDescriptorSupplier
      extends DoctorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DoctorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DoctorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DoctorServiceFileDescriptorSupplier())
              .addMethod(getDoctorMethod())
              .addMethod(getRegisterDoctorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
