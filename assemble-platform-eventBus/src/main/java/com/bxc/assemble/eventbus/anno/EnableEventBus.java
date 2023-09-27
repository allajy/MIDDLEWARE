package com.bxc.assemble.eventbus.anno;

import com.bxc.assemble.eventbus.config.EventBusConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@SpringBootConfiguration
@Import(EventBusConfiguration.class)
public @interface EnableEventBus {
}
