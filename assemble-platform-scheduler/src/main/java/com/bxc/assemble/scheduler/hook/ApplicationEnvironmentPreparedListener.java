package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.console.hook
 * @description: Environment（profile、属性配置等）创建和初始化好了
 */
@Component
@Slf4j
public class ApplicationEnvironmentPreparedListener<A extends SpringApplicationEvent> implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        log.info("ApplicationEnvironmentPreparedListener object is to be call -" +
                " Environment（profile、属性配置等）创建和初始化好了:{}",applicationEnvironmentPreparedEvent.getSource());
    }
}
