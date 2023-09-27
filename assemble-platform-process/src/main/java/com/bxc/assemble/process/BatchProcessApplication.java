package com.bxc.assemble.process;

import cn.hutool.core.net.NetUtil;
import com.bxc.assemble.process.tasker.SchedulerController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;

@Slf4j
@EnableBatchProcessing
@SpringBootApplication
public class BatchProcessApplication {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        ApplicationContext applicationContext = SpringApplication.run(BatchProcessApplication.class,args);
        ServerProperties serverProperties = applicationContext.getBean(ServerProperties.class);
        log.info("请访问swagger访问页面：{}", "http://"+ NetUtil.localIpv4s().stream().findFirst().get()+":"+
                serverProperties.getPort()+"/doc.html");
    }
}
