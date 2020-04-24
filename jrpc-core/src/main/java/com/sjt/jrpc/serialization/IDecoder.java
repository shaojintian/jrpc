package com.sjt.jrpc.serialization;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sjt.jrpc.protocol.JRpcProto.*;

public interface IDecoder {

    RpcRequestMeta decodeReq(byte[] req)throws InvalidProtocolBufferException;

    RpcResponseMeta decodeRes(byte[] res)throws InvalidProtocolBufferException;
}
