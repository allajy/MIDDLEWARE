package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.console.hook
 * @description: 容器完全准备好了，但是bean definition还没有加载 refresh() --- 具体的注入bean
 * 应用准备完成，开始定义bean，但还没有刷新到上下文
 */
@Component
@Slf4j
public class ApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        log.info("ApplicationPreparedListener object is to be call -" +
                " 容器完全准备好了，但是bean definition还没有加载 refresh() --- 具体的注入bean:{}",applicationPreparedEvent.getSource());
    }
}
