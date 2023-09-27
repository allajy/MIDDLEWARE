package com.bxc.assemble.redisdelayer.anno;

import com.bxc.assemble.redisdelayer.config.DelayedQueueConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@SpringBootConfiguration
@Import(DelayedQueueConfiguration.class)
public @interface EnableDelayedQueue {
}
