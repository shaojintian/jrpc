package com.sjt.jrpc.server.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

public class RpcServiceProviderStreamThread<T> implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RpcServiceProviderStreamThread.class);
    private Socket socket;
    private T obj;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public RpcServiceProviderStreamThread(T obj, Socket socket){
        this.socket =socket;
        this.obj=obj;
    }

    @Override
    public void run(){
        //服务端接受invoked method params,types and method name && class which this method in
        try {
            ois =  new ObjectInputStream(socket.getInputStream());
            //params values
            Object[] paramsValues  =(Object[]) ois.readObject();
            //params types
            Class[] paramsTypes = (Class[])ois.readObject();
            //method name
            String mName = (String)ois.readObject();
            //get specific method in this class
            Method method  = obj.getClass().getMethod(mName, paramsTypes);
            //do method
            Object ans = method.invoke(obj, paramsValues);
            //write ans to oos
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(ans);
            logger.info("Sending ans to client...");
        }catch (Exception e){
            logger.error("server err");
        }finally {
            close(ois);
            close(oos);
            close(socket);
        }

    }

    private void close(Closeable closeable) {
        if (closeable!=null){
            try {
                closeable.close();
            }catch (IOException e){
                logger.error(e+"");
            }
        }
    }

}
