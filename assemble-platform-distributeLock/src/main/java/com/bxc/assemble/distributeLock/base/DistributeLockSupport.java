package com.bxc.assemble.distributeLock.base;

import com.google.common.base.Joiner;

/**
 * @project-name:callcenter
 * @package-name:com.bxc.callcenter.extense.dlock
 * @description: 分布式锁的接口
 */
public interface DistributeLockSupport<T> {


    /**
     * 默认的分隔符
     */
    String DEFAULT_DELIMTER = ":";


    String DEFAULT_KEY_PREFIX = "LOCK";


    Long DEFAULT_EXPIRE_TIME = 10L;


    Long DEFAULT_WAIT_TIME = 10L;


    Joiner DEFAULT_JOINER = Joiner.on(DistributeLockSupport.DEFAULT_DELIMTER).
            skipNulls();


    /**
     * 加锁
     * @param distributeLockParam
     * @return
     */
    T lock(DistributeLockParam distributeLockParam);

    /**
     * 解锁
     * @param distributeLockParam
     */
    void unlock(T param, DistributeLockParam distributeLockParam);

}
