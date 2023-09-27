package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.scheduler.hook
 * @description:
 */
@Slf4j
@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("ContextRefreshedListener object is to be call - 这个上下文刷新事件是在 Spring 应用上下文（ApplicationContext）刷新之后发送:{}",contextRefreshedEvent.getSource());
    }
}
