package com.bxc.assemble.eventbus.spring;

import com.bxc.assemble.eventbus.EventListener;
import com.bxc.assemble.eventbus.EventListenerRegistry;
import com.bxc.assemble.eventbus.disruptor.EventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
//@ConditionalOnExpression("'${event-bus.model}'.equalsIgnoreCase('spring')")
@Component("spring")
public class SpringEventListenerRegistry implements EventListenerRegistry<EventModel> {


    @Autowired
    ApplicationContext applicationContext;



    final List<EventListener> eventListeners;


    public SpringEventListenerRegistry(List<EventListener> eventListeners) {
        this.eventListeners = eventListeners;
    }



    @PostConstruct
    public void init(){
        log.info("开始初始化Spring事件监听器的组件服务");
        initRegistryEventListener(eventListeners);
        log.info("完成初始化Spring事件监听器的组件服务：{}",eventListeners);
    }


    @Override
    public void initRegistryEventListener(List<EventListener> eventConsumerList) {

    }


    @Override
    public void publish(EventModel param) {
        applicationContext.publishEvent(param);
    }
}
