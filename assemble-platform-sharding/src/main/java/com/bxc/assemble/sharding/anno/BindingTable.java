package com.bxc.assemble.sharding.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Component
@Autowired(required = false)
@Qualifier("broadcastTable")
public @interface BindingTable {

    String relation();

}
