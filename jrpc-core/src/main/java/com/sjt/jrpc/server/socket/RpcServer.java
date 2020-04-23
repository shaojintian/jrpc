package com.sjt.jrpc.server.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcServer {
    private static final Logger logger = LoggerFactory.getLogger(RpcServer.class);
    /**
     * based on socket && don't need serialization
     * @param obj
     * @param port
     * @param <T>
     * @throws IOException
     */
    public static <T> void startService(T obj , int port) throws IOException{
        ServerSocket  serverSocket = new ServerSocket(port);
        //server never stop
        logger.info("Waiting a socket in ");
        while (true){
            final Socket socket =  serverSocket.accept();
            logger.info("start",socket);
            //并发处理所有调用逻辑
            RpcServiceProviderThread<T> thread  = new RpcServiceProviderThread<T>(obj ,socket);
            thread.run();
        }

    }

}
