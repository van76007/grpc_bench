package io.grpc.examples.helloworld;

import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GreetingServiceImpl extends GreeterGrpc.GreeterImplBase {
  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder().setResponse(request.getRequest()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}