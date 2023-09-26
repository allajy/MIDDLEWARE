package com.bxc.assemble.minio.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@SpringBootApplication
@Import(MinioConfiguration.class)
public @interface EnableMinioClient {
}
