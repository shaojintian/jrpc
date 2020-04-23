package com.sjt.jrpc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JRpcServiceProviderUtil {
    private static final Logger logger = LoggerFactory.getLogger(JRpcServiceProviderUtil.class);
    /**
     * based on socket
     * @param obj
     * @param port
     * @param <T>
     * @throws IOException
     */
    public static <T> void startService(T obj , int port) throws IOException{
        ServerSocket  serverSocket = new ServerSocket();
        while (true){
            final Socket socket =  serverSocket.accept();
            logger.info("start",socket);

        }

    }

}
