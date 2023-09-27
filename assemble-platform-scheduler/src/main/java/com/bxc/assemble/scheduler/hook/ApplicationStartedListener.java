package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.console.hook
 * @description: 初始化完成
 */
@Component
@Slf4j
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("ApplicationStartedListener object is to be call - 初始化完成:{}",applicationStartedEvent.getSource());
    }
}
