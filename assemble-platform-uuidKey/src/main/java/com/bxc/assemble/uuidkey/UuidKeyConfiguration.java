package com.bxc.assemble.uuidkey;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
/**
 * @project-name:assemble-platform
 * @package-name:com.bxc.assemble.uuidkey
 */
@ComponentScan("com.bxc.assemble.uuidkey")
@MapperScan("com.bxc.assemble.uuidkey.uidgen.mapper")
@Configuration
@EnableAutoConfiguration
public class UuidKeyConfiguration {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(UuidKeyConfiguration.class,args);
        ServerProperties serverProperties = applicationContext.getBean(ServerProperties.class);
        log.info("请访问swagger访问页面：{}", "http://"+ NetUtil.localIpv4s().stream().findFirst().get()+":"+
                serverProperties.getPort()+"/docs.html");
    }
}
