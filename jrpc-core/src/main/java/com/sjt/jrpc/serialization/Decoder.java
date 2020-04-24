package com.sjt.jrpc.serialization;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sjt.jrpc.protocol.JRpcProto;
import com.sjt.jrpc.protocol.JRpcProto.RpcRequestMeta;
import com.sjt.jrpc.protocol.JRpcProto.RpcResponseMeta;
import com.sjt.jrpc.request.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Decoder implements IDecoder {
    private static final Logger logger = LoggerFactory.getLogger(Decoder.class);
    private Decoder(){}
    private static final Decoder INSTANCE = new Decoder();

    public static Decoder getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public RpcRequestMeta decodeReq(byte[] req)throws InvalidProtocolBufferException {
        if (req==null){logger.error("...");}
        return RpcRequestMeta.parseFrom(req);
    }
    @Override
    public RpcResponseMeta decodeRes(byte[] res )throws InvalidProtocolBufferException{
        if (res==null){logger.error("...");}
        return RpcResponseMeta.parseFrom(res);
    }
}
