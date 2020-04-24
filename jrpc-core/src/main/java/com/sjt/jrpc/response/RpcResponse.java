package com.sjt.jrpc.response;

import lombok.Builder;

@Builder
public class RpcResponse {
    private String serviceName = null;
    private String methodName = null;
    private Class[] parameterTypes = null;
    private Object[] args = null;
    private long logId = -1;
    private long traceId = -1;
    private long spanId = -1;
    private long parentSpanId = -1;
}
