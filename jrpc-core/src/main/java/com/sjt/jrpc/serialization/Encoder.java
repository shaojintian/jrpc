package com.sjt.jrpc.serialization;

import com.sjt.jrpc.protocol.JRpcProto.RpcRequestMeta;
import com.sjt.jrpc.protocol.JRpcProto.RpcResponseMeta;
import com.google.protobuf.Message;


/**
 * singleton pattern
 */
public class Encoder implements IEncoder{
    private Encoder(){};
    private static final Encoder INSTANCE  = new Encoder();


    public static Encoder getInstance(){return INSTANCE;}

    @Override
    public byte[] encodeReq(RpcRequestMeta req){
        if(req==null){
            throw new IllegalArgumentException("illegal req");
        }
        return req.toByteArray();
    }

    @Override
    public byte[] encodeRes(RpcResponseMeta res){
        if(res==null){
            throw new IllegalArgumentException("illegal res");
        }
        return res.toByteArray();
    }

}
