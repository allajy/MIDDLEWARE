package com.bxc.assemble.circuitbreaker.annon;


@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Documented
public @interface CircuitBreakerControl {

    String resourceName();
}
