package com.sjt.jrpc.serialization;

import com.sjt.jrpc.protocol.JRpcProto.RpcRequestMeta;
import com.sjt.jrpc.protocol.JRpcProto.RpcResponseMeta;

public interface IEncoder {

     byte[] encodeReq(RpcRequestMeta req);

     byte[] encodeRes(RpcResponseMeta res);

}
