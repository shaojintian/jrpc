package com.sjt.jrpc.proxy.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class DynamicProxy {
    private static final Logger logger  = LoggerFactory.getLogger(DynamicProxy.class);
    private String host;
    private int port;

    public DynamicProxy(String host,int port){
        this.host = host;
        this.port = port;
    }

    public Object createProxy(Object proxiedObj){
        Class<?>[] interfaces = proxiedObj.getClass().getInterfaces();
        Handler handler = new Handler();
        return Proxy.newProxyInstance(proxiedObj.getClass().getClassLoader(),interfaces, handler);
    }

    public class Handler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
            //rpc proxy
            Object ans=null;
            Socket socket = new Socket(host,port);
            ObjectOutputStream oos=null;
            ObjectInputStream ois=null;
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
                //args
                oos.writeObject(args);
                //types
                Class[] paramsTypes = method.getParameterTypes();
                oos.writeObject(paramsTypes);
                //m name
                oos.writeObject(method.getName());
                // read ans from socket
                ois = new ObjectInputStream(socket.getInputStream());
                ans = ois.readObject();
                logger.info("rpc ans: "+ans);
            }catch (Exception e){
                logger.error(e+"");
            }finally {
                close(oos);
                close(ois);
                close(socket);
            }
            return ans;
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


}
