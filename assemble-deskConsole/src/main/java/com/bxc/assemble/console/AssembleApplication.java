package com.bxc.assemble.console;

import cn.hutool.core.net.NetUtil;
import com.bxc.assemble.minio.config.EnableMinioClient;
import com.bxc.assemble.process.config.Knif4jConfiguration;
import com.bxc.assemble.ratelimiter.EnableRateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootApplication
@Import(Knif4jConfiguration.class)
@EnableRateLimiter
//@EnableEventBus
//@EnableUUIDKey
//@EnableTaskQueueProxy
//@EnableMinioClient
//@EnableDelayedQueue
public class AssembleApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AssembleApplication.class,args);
        ServerProperties serverProperties = applicationContext.getBean(ServerProperties.class);
        log.info("请访问swagger访问页面：{}", "http://"+ NetUtil.localIpv4s().stream().findFirst().get()+":"+
                serverProperties.getPort()+"/doc.html");
    }

}