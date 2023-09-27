package com.bxc.assemble.uuidkey.config;

import com.bxc.assemble.uuidkey.UuidKeyConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Import(UuidKeyConfiguration.class)
public @interface EnableUUIDKey {
}
