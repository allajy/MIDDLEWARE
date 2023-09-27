package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.common.hook
 * @description: 开始容器初始化
 */
@Component
@Slf4j
public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        log.info("ApplicationStartingListener object is to be call - 开始容器初始化:{}",applicationStartingEvent.getSource());
    }

}
