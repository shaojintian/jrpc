package com.sjt.jrpc.serialization;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import com.sjt.jrpc.protocol.JRpcProto.RpcRequestMeta;
import com.sjt.jrpc.protocol.JRpcProto.RpcResponseMeta;
import com.google.protobuf.Any;


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
    @Override
    public <T extends Message>Any pack(T msg){
        return Any.newBuilder()
                .setTypeUrl(getTypeUrl("type.googleapis.com",msg.getDescriptorForType()))
                .setValue(msg.toByteString())
                .build();
    }
    public String getTypeUrl(String url, Descriptors.Descriptor descriptor){

        return "";
    }

}
