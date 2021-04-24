package com.proto.patient;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: patient/patient.proto")
public final class PatientServiceGrpc {

  private PatientServiceGrpc() {}

  public static final String SERVICE_NAME = "patient.PatientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.patient.PatientRequest,
      com.proto.patient.PatientResponse> getPatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Patient",
      requestType = com.proto.patient.PatientRequest.class,
      responseType = com.proto.patient.PatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.patient.PatientRequest,
      com.proto.patient.PatientResponse> getPatientMethod() {
    io.grpc.MethodDescriptor<com.proto.patient.PatientRequest, com.proto.patient.PatientResponse> getPatientMethod;
    if ((getPatientMethod = PatientServiceGrpc.getPatientMethod) == null) {
      synchronized (PatientServiceGrpc.class) {
        if ((getPatientMethod = PatientServiceGrpc.getPatientMethod) == null) {
          PatientServiceGrpc.getPatientMethod = getPatientMethod =
              io.grpc.MethodDescriptor.<com.proto.patient.PatientRequest, com.proto.patient.PatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Patient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.patient.PatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.patient.PatientResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PatientServiceMethodDescriptorSupplier("Patient"))
              .build();
        }
      }
    }
    return getPatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.patient.PatientAverageRequest,
      com.proto.patient.PatientAverageResponse> getPatientAverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PatientAverage",
      requestType = com.proto.patient.PatientAverageRequest.class,
      responseType = com.proto.patient.PatientAverageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.patient.PatientAverageRequest,
      com.proto.patient.PatientAverageResponse> getPatientAverageMethod() {
    io.grpc.MethodDescriptor<com.proto.patient.PatientAverageRequest, com.proto.patient.PatientAverageResponse> getPatientAverageMethod;
    if ((getPatientAverageMethod = PatientServiceGrpc.getPatientAverageMethod) == null) {
      synchronized (PatientServiceGrpc.class) {
        if ((getPatientAverageMethod = PatientServiceGrpc.getPatientAverageMethod) == null) {
          PatientServiceGrpc.getPatientAverageMethod = getPatientAverageMethod =
              io.grpc.MethodDescriptor.<com.proto.patient.PatientAverageRequest, com.proto.patient.PatientAverageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PatientAverage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.patient.PatientAverageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.patient.PatientAverageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PatientServiceMethodDescriptorSupplier("PatientAverage"))
              .build();
        }
      }
    }
    return getPatientAverageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PatientServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PatientServiceStub>() {
        @java.lang.Override
        public PatientServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PatientServiceStub(channel, callOptions);
        }
      };
    return PatientServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PatientServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PatientServiceBlockingStub>() {
        @java.lang.Override
        public PatientServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PatientServiceBlockingStub(channel, callOptions);
        }
      };
    return PatientServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PatientServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PatientServiceFutureStub>() {
        @java.lang.Override
        public PatientServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PatientServiceFutureStub(channel, callOptions);
        }
      };
    return PatientServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PatientServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary API
     * </pre>
     */
    public void patient(com.proto.patient.PatientRequest request,
        io.grpc.stub.StreamObserver<com.proto.patient.PatientResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPatientMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client Streaming API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.patient.PatientAverageRequest> patientAverage(
        io.grpc.stub.StreamObserver<com.proto.patient.PatientAverageResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPatientAverageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPatientMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.proto.patient.PatientRequest,
                com.proto.patient.PatientResponse>(
                  this, METHODID_PATIENT)))
          .addMethod(
            getPatientAverageMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.proto.patient.PatientAverageRequest,
                com.proto.patient.PatientAverageResponse>(
                  this, METHODID_PATIENT_AVERAGE)))
          .build();
    }
  }

  /**
   */
  public static final class PatientServiceStub extends io.grpc.stub.AbstractAsyncStub<PatientServiceStub> {
    private PatientServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PatientServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary API
     * </pre>
     */
    public void patient(com.proto.patient.PatientRequest request,
        io.grpc.stub.StreamObserver<com.proto.patient.PatientResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client Streaming API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.patient.PatientAverageRequest> patientAverage(
        io.grpc.stub.StreamObserver<com.proto.patient.PatientAverageResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getPatientAverageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PatientServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PatientServiceBlockingStub> {
    private PatientServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PatientServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary API
     * </pre>
     */
    public com.proto.patient.PatientResponse patient(com.proto.patient.PatientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatientMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PatientServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PatientServiceFutureStub> {
    private PatientServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PatientServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary API
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.patient.PatientResponse> patient(
        com.proto.patient.PatientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPatientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PATIENT = 0;
  private static final int METHODID_PATIENT_AVERAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PATIENT:
          serviceImpl.patient((com.proto.patient.PatientRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.patient.PatientResponse>) responseObserver);
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
        case METHODID_PATIENT_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.patientAverage(
              (io.grpc.stub.StreamObserver<com.proto.patient.PatientAverageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PatientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.patient.Patient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientService");
    }
  }

  private static final class PatientServiceFileDescriptorSupplier
      extends PatientServiceBaseDescriptorSupplier {
    PatientServiceFileDescriptorSupplier() {}
  }

  private static final class PatientServiceMethodDescriptorSupplier
      extends PatientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PatientServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PatientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientServiceFileDescriptorSupplier())
              .addMethod(getPatientMethod())
              .addMethod(getPatientAverageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
