package com.bxc.assemble.redisdelayer.sample;

import com.bxc.assemble.redisdelayer.listener.DelayedExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultSampleDelayedExceptionHandler implements DelayedExceptionHandler {

    @Override
    public void catchException(Throwable e, Thread currentThread) {
        log.error("current thread is failure -> current thread Name:{}"+currentThread.getName(),e);
    }

}
