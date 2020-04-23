package io.grpc.hello;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.15.0)",
    comments = "Source: hello.proto")
public class HelloServiceGrpc {

  private HelloServiceGrpc() {}

  public static final String SERVICE_NAME = "hello.HelloService";

  // Static methodInfo descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.hello.HelloRequest,
      io.grpc.hello.HelloReply> METHOD_SAY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hello.HelloService", "Say"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.hello.HelloRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.hello.HelloReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloServiceStub newStub(io.grpc.Channel channel) {
    return new HelloServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static HelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloServiceFutureStub(channel);
  }

  /**
   */
  @java.lang.Deprecated public static interface HelloService {

    /**
     */
    public void say(io.grpc.hello.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.hello.HelloReply> responseObserver);
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1469")
  public static abstract class HelloServiceImplBase implements HelloService, io.grpc.BindableService {

    @java.lang.Override
    public void say(io.grpc.hello.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.hello.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return HelloServiceGrpc.bindService(this);
    }
  }

  /**
   */
  @java.lang.Deprecated public static interface HelloServiceBlockingClient {

    /**
     */
    public io.grpc.hello.HelloReply say(io.grpc.hello.HelloRequest request);
  }

  /**
   */
  @java.lang.Deprecated public static interface HelloServiceFutureClient {

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.hello.HelloReply> say(
        io.grpc.hello.HelloRequest request);
  }

  public static class HelloServiceStub extends io.grpc.stub.AbstractStub<HelloServiceStub>
      implements HelloService {
    private HelloServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void say(io.grpc.hello.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.hello.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAY, getCallOptions()), request, responseObserver);
    }
  }

  public static class HelloServiceBlockingStub extends io.grpc.stub.AbstractStub<HelloServiceBlockingStub>
      implements HelloServiceBlockingClient {
    private HelloServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public io.grpc.hello.HelloReply say(io.grpc.hello.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAY, getCallOptions(), request);
    }
  }

  public static class HelloServiceFutureStub extends io.grpc.stub.AbstractStub<HelloServiceFutureStub>
      implements HelloServiceFutureClient {
    private HelloServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.hello.HelloReply> say(
        io.grpc.hello.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAY, getCallOptions()), request);
    }
  }

  @java.lang.Deprecated public static abstract class AbstractHelloService extends HelloServiceImplBase {}

  private static final int METHODID_SAY = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloService serviceImpl;
    private final int methodId;

    public MethodHandlers(HelloService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY:
          serviceImpl.say((io.grpc.hello.HelloRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.hello.HelloReply>) responseObserver);
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

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_SAY);
  }

  @java.lang.Deprecated public static io.grpc.ServerServiceDefinition bindService(
      final HelloService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          METHOD_SAY,
          asyncUnaryCall(
            new MethodHandlers<
              io.grpc.hello.HelloRequest,
              io.grpc.hello.HelloReply>(
                serviceImpl, METHODID_SAY)))
        .build();
  }
}
