package com.sjt.jrpc;

import com.sjt.jrpc.server.socket.RpcServer;

public class TestRpcServer {
    public static void main(String[] args) {
        try {
            RpcServer.startService(new Add(), 50051);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
