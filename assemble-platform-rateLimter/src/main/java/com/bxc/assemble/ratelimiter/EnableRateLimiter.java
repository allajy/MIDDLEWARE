package com.bxc.assemble.ratelimiter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;

@java.lang.annotation.Target({ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@Import(RateLimiterConfiguration.class)
public @interface EnableRateLimiter {

}
