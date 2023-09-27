package com.bxc.assemble.scheduler.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.scheduler.hook
 * @description:
 */
@Slf4j
@Component
public class WebServerInitializedListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        log.info("WebServerInitializedListener object is to be call - " +
                "这个 Web 服务器初始化事件在 WebServer 启动之后发送，对应的还有 ServletWebServerInitializedEvent（Servlet Web 服务器初始化事件）" +
                ":{}",webServerInitializedEvent.getSource());
    }
}
