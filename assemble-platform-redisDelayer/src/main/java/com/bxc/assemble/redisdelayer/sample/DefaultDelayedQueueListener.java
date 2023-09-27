package com.bxc.assemble.redisdelayer.sample;

import com.bxc.assemble.redisdelayer.anno.DelayedQueueListener;
import com.bxc.assemble.redisdelayer.listener.EventExecutableInvokerListener;
import com.bxc.assemble.redisdelayer.model.ExecuteInvokerEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;

@Slf4j
@DelayedQueueListener(value="delayedQueueListener",group = "test_delayed_queue")
public class DefaultDelayedQueueListener implements EventExecutableInvokerListener<Object,Object> {

    @Override
    public Executor getExecutor() {
        return null;
    }

    @Override
    public Object handle(ExecuteInvokerEvent<Object> param) {
        log.info("input the parameter:{}",param);
        return param;
    }
}
