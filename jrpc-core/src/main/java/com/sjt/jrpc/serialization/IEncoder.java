package com.sjt.jrpc.serialization;

import com.google.protobuf.Any;
import com.google.protobuf.Message;
import com.sjt.jrpc.protocol.JRpcProto.RpcRequestMeta;
import com.sjt.jrpc.protocol.JRpcProto.RpcResponseMeta;

public interface IEncoder {

     byte[] encodeReq(RpcRequestMeta req);

     byte[] encodeRes(RpcResponseMeta res);

     <T extends Message> Any pack(T msg);

}
