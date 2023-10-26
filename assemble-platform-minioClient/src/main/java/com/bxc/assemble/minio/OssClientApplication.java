package com.bxc.assemble.minio;

import cn.hutool.core.net.NetUtil;
import com.bxc.assemble.common.config.SwaggerConfiguration;
import com.jvm123.minio.config.MinioProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class OssClientApplication {

    public static void main(String[] args) {
        try{
            ApplicationContext applicationContext = SpringApplication.run(OssClientApplication.class, args);
            log.info("请访问MINIO控制台：{}",applicationContext.getBean(MinioProperties.class).getEndpoint().replace("9001","9000"));
            ServerProperties serverProperties = applicationContext.getBean(ServerProperties.class);
            log.info("请访问swagger访问页面：{}","http://"+ NetUtil.localIpv4s().stream().findFirst().get()+":"+
                    serverProperties.getPort()+"/doc.html");
        } catch (Exception e) {
            log.error("程序异常:", e);
        }
    }

}
