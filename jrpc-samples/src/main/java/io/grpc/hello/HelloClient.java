package io.grpc.hello;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class HelloClient {

    private final ManagedChannel channel;
    private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;


    public HelloClient(ManagedChannel channel){
        this.channel =channel;
        blockingStub = HelloServiceGrpc.newBlockingStub(this.channel);
    }

    public HelloClient(String host,int port){
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    /**
     * showdown positively
     * @throws InterruptedException
     */
    public void shutdown() throws InterruptedException{
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * send rpc req
     */
    public void say(String name){

        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response= blockingStub.say(request);
            System.out.println("req: "+request.getName());
        }catch (Exception e){
            return;
        }
        System.out.println("response: "+response);
    }

    public static void main(String[] args) {
        HelloClient client = new HelloClient("127.0.0.1", 50051);
        try {
            client.say("sjt");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                client.shutdown();
            }catch (InterruptedException e){
                System.out.println(e);
            }

        }
    }

}
