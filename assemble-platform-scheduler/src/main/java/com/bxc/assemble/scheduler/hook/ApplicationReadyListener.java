package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.console.hook
 * @description: 处在运行中了
 */
@Component
@Slf4j
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("ApplicationReadyListener object is to be call - 处在运行中了:{}",applicationReadyEvent.getSource());
    }
}
