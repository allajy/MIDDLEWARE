package com.bxc.assemble.minio.rpcapi;

import com.bxc.assemble.minio.model.OssProcessDTO;
import com.hyts.assemble.common.model.rpc.RpcRequest;
import com.hyts.assemble.common.model.rpc.RpcResponse;

public interface RpcOssOperateRpcApi {

    /**
     * bucket
     * @param rpcRequest:内部存储对应的BucketName
     * @return
     */
    RpcResponse create(RpcRequest<String> rpcRequest);


    /**
     * 存储文件
     * @param rpcRequest filePath和bucketName
     * @return
     */
    RpcResponse upload(RpcRequest<OssProcessDTO> rpcRequest);

    /**
     * 删除文件
     * @param rpcRequest bucketName 和 fileName
     * @return
     */
    RpcResponse remove(RpcRequest<OssProcessDTO> rpcRequest);


    /**
     * 下载文件
     * @param rpcRequest bucketName 和 fileName
     * @return
     */
    RpcResponse download(RpcRequest<OssProcessDTO> rpcRequest);

}
