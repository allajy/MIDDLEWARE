package com.bxc.assemble.scheduler.hook;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @project-name:assemble-platform
 * @package-name:com.bxc.assemble.scheduler.hook
 * @description: 启动失败触发
 */
public class AvailabilityChangeListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {

    }
}
