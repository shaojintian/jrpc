package io.grpc.hello;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.*;

import java.io.IOException;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

public class HelloServer {

    private Server server;

    private void start() throws IOException{
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                HelloServer.this.stop();
            }
        });
    }

    private void stop() {
        if(server!=null){
            server.shutdown();
        }
    }

    /**
     * stop graciously
     */
    private void blockUntilShutdown() throws InterruptedException{
       if(server!=null){
           server.awaitTermination();
       }
    }



    private  static class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase{

        @Override
        public void say(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            HelloReply reply = HelloReply.newBuilder()
                                        .setMessage("hello "+request.getName())
                                        .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

    }


    public static void main(String[] args) {
        final HelloServer helloServer = new HelloServer();
        try {
            helloServer.start();
        }catch (IOException e){
            System.out.println(e);
        }finally {
            try {
                helloServer.blockUntilShutdown();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
