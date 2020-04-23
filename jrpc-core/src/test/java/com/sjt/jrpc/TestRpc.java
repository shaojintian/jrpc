package com.sjt.jrpc;

import com.sjt.jrpc.proxy.socket.DynamicProxy;

public class TestRpc {

    public static void main(String[] args) {
        DynamicProxy dp = new DynamicProxy("localhost", 50051);
        IAdd rpcAdd = (IAdd) dp.createProxy(new Add());
        for (int i = 0; i <100000; i++) {
            rpcAdd.add(1, 2);
        }

    }
}
