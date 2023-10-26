package com.bxc.assemble.distributeLock.base;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @project-name:callcenter
 * @package-name:com.bxc.callcenter.extense.dlock
 * @description: 分布式锁Param参数
 */
@Data
public class DistributeLockParam {


    private String lockUUid;


    private String lockNamePrefix;



    private Long expireTime;


    private Long waitTime;


    private TimeUnit timeUnit;


    private String delimiter;


    private DistributeLockType lockType;


}
