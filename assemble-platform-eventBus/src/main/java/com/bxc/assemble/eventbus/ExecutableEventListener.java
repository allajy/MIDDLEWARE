package com.bxc.assemble.eventbus;

import com.google.common.eventbus.Subscribe;
import com.bxc.assemble.eventbus.disruptor.EventModel;
import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public abstract class ExecutableEventListener implements EventListener<EventModel<?>>, EventHandler<EventModel<?>> {



    @org.springframework.context.event.EventListener
    @Subscribe
    @Override
    public void onMessage(EventModel<?> message) {
        log.info("系统监听明细执行启动服务监听器:{}",message);
        if(topic().equals(message.getTopic())) {
            handle(message);
        }
    }



    @Override
    public void onEvent(EventModel<?> objectEventModel, long l, boolean b) throws Exception {
//        log.info("接收到执行监听器驱动为:disruptor");
        onMessage(objectEventModel);
    }

    /**
     * 操作处理机制控制！
     * @param message
     */
    public abstract void handle(EventModel message);

}
