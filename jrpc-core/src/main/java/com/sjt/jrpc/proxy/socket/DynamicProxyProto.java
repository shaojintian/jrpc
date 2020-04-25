package com.sjt.jrpc.proxy.socket;

import com.sjt.jrpc.protocol.JRpcProto;
import com.sjt.jrpc.protocol.JRpcProto.*;
import com.sjt.jrpc.response.RpcResponse;
import com.sjt.jrpc.serialization.Encoder;
import com.sun.media.sound.SoftLowFrequencyOscillator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Beans;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ResponseCache;
import java.net.Socket;

public class DynamicProxyProto {
    private static final Logger logger  = LoggerFactory.getLogger(DynamicProxyStream.class);
    private String host;
    private int port;

    public DynamicProxyProto(String host, int port){
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
            RpcResponseMeta responseMeta=null;
            Socket client = new Socket(host,port);
            OutputStream oos=null;
            InputStream ois=null;
            try {
                //send param types,args,method name
                //build req
                //param types
                Class<?>[] paramsTypes = method.getParameterTypes();
                ParamsTypes wrappedParamsTypes = ParamsTypes.newBuilder().build();
                ParamsValues wrappedParamsValues = ParamsValues.newBuilder().build();
                RpcRequestMeta requestMeta = RpcRequestMeta.newBuilder()
                                                            .setMethodName(method.getName())
                                                            .setParamsTypes(wrappedParamsTypes)
                                                            .setParamsValues(wrappedParamsValues)
                                                            .build();
                //serialization
                byte[] req  = Encoder.getInstance().encodeReq(requestMeta);
                //do send
                oos.write(req);
                //receive ans
                byte[] ans = new byte[1024];
                ois.read(ans);
                //deserialization
                responseMeta  = RpcResponseMeta.newBuilder().build();
                logger.info("rpc ans: "+responseMeta);
            }catch (Exception e){
                logger.error(e+"");
            }finally {
                close(oos);
                close(ois);
                close(client);
            }
            return responseMeta;
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
