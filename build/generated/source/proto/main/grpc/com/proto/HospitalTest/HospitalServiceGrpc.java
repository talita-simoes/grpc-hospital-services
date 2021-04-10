package com.proto.HospitalTest;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: HospitalTest/servicetest.proto")
public final class HospitalServiceGrpc {

  private HospitalServiceGrpc() {}

  public static final String SERVICE_NAME = "HospitalTest.HospitalService";

  // Static method descriptors that strictly reflect the proto.
  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HospitalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceStub>() {
        @java.lang.Override
        public HospitalServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceStub(channel, callOptions);
        }
      };
    return HospitalServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HospitalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceBlockingStub>() {
        @java.lang.Override
        public HospitalServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceBlockingStub(channel, callOptions);
        }
      };
    return HospitalServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HospitalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceFutureStub>() {
        @java.lang.Override
        public HospitalServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceFutureStub(channel, callOptions);
        }
      };
    return HospitalServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HospitalServiceImplBase implements io.grpc.BindableService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .build();
    }
  }

  /**
   */
  public static final class HospitalServiceStub extends io.grpc.stub.AbstractAsyncStub<HospitalServiceStub> {
    private HospitalServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HospitalServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HospitalServiceBlockingStub> {
    private HospitalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HospitalServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HospitalServiceFutureStub> {
    private HospitalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceFutureStub(channel, callOptions);
    }
  }


  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HospitalServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HospitalServiceImplBase serviceImpl, int methodId) {
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HospitalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HospitalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.HospitalTest.Servicetest.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HospitalService");
    }
  }

  private static final class HospitalServiceFileDescriptorSupplier
      extends HospitalServiceBaseDescriptorSupplier {
    HospitalServiceFileDescriptorSupplier() {}
  }

  private static final class HospitalServiceMethodDescriptorSupplier
      extends HospitalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HospitalServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HospitalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HospitalServiceFileDescriptorSupplier())
              .build();
        }
      }
    }
    return result;
  }
}
