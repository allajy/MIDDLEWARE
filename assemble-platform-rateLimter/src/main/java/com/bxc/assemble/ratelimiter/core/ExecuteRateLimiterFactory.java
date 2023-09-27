package com.bxc.assemble.ratelimiter.core;

@FunctionalInterface
public interface ExecuteRateLimiterFactory<P,R> {

    R create(P param);
}
