package com.bxc.assemble.ratelimiter.core;

@FunctionalInterface
public interface ExecuteRateLimiter<P,R>{

    /**
     * 执行操作
     * @param param
     * @return
     */
    R execute(P param);
}
