package com.bxc.assemble.eventbus.guava;

import cn.hutool.core.thread.ThreadUtil;
import com.bxc.assemble.eventbus.EventListener;
import com.bxc.assemble.eventbus.EventListenerRegistry;
import com.bxc.assemble.eventbus.disruptor.EventModel;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.objenesis.instantiator.util.ClassUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executor;


@Slf4j
//@ConditionalOnExpression("'${event-bus.model}'.equalsIgnoreCase('guava')")
@Component("guava")
public class GuavaEventListenerRegistry implements EventListenerRegistry<EventModel> {


    EventBus eventBus;


    final List<EventListener> eventListeners;

    /**
     * 构造器方式的注入方式
     * @param eventListeners
     */
    public GuavaEventListenerRegistry(List<EventListener> eventListeners) {
        this.eventListeners = eventListeners;
    }


    @PostConstruct
    public void init(){
        log.info("开始初始化Guava事件监听器的组件服务");
        initRegistryEventListener(eventListeners);
        log.info("完成初始化Guava事件监听器的组件服务");
    }


    /**
     * 注册监听器操作
     * @param eventConsumerList
     */
    @Override
    public void initRegistryEventListener(List<EventListener> eventConsumerList) {
        Executor executor = ThreadUtil.newExecutor(10,20,300);
        eventBus = new AsyncEventBus(GuavaEventListenerRegistry.class.getName(),executor);
        eventConsumerList.stream().forEach(param->{
            log.info("注册服务监听器:{}",param.getClass());
            eventBus.register(ClassUtils.newInstance(param.getClass()));
        });
    }


    /**
     * 发布事件操作
     * @param param
     */
    @Override
    public void publish(EventModel param) {
        eventBus.post(param);
    }

    
}
