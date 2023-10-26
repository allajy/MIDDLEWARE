package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.bxc.assemble.console.hook
 * @description:  context上下文本身创建和初始化好了，ApplicationContextInitializer都已经执行了,上下文初始化完成
 */
@Component
@Slf4j
public class ApplicationContextInitializedListener implements ApplicationListener<ApplicationContextInitializedEvent> {


    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent applicationContextInitializedEvent) {
        log.info("ApplicationContextInitializedListener object is to be call -" +
                " context上下文本身创建和初始化好了，ApplicationContextInitializer都已经执行了:{}",
                applicationContextInitializedEvent.getSource());
    }
}
