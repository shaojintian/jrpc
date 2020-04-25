package com.sjt.jrpc.server.socket;

import com.sjt.jrpc.protocol.JRpcProto;
import com.sjt.jrpc.response.RpcResponse;
import com.sjt.jrpc.serialization.Decoder;
import com.sjt.jrpc.serialization.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import com.sjt.jrpc.protocol.JRpcProto.*;

public class RpcServiceProviderProtoThread<T> implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RpcServiceProviderStreamThread.class);
    private Socket socket;
    private T obj;
    private InputStream is;
    private OutputStream os;

    public RpcServiceProviderProtoThread(Socket socket){
        this.socket =socket;
        this.obj=obj;
    }

    @Override
    public void run(){
        //服务端接受invoked method params,types and method name && class which this method in
        try {
            //receive req
            is = socket.getInputStream();
            byte[] req = new byte[1024];
            is.read(req);
            //deserialization
            RpcRequestMeta requestMeta = Decoder.getINSTANCE().decodeReq(req);
            //do method
            String mName = requestMeta.getMethodName();
            Class<?>[] paramTypes =(Class<?>[]) requestMeta.getParamsTypes();
            Object[] args = (Object[])requestMeta.getParamsValues();
            Method method = obj.getClass().getMethod(mName,paramTypes);
            Object ans = method.invoke(obj, args);
            //build response
            RpcResponseMeta responseMeta = RpcResponseMeta
                                                        .newBuilder()
                                                        .build();
            //serialization
            byte[] res = Encoder.getInstance().encodeRes(responseMeta);
            //write response to oos
            os = socket.getOutputStream();
            os.write(res);
            logger.info("Sending ans to client...");
        }catch (Exception e){
            logger.error("server err");
        }finally {
            close(is);
            close(os);
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
