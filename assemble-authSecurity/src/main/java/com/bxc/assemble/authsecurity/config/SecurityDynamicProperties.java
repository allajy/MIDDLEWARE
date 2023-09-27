package com.bxc.assemble.authsecurity.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component
public class SecurityDynamicProperties {

    @Getter
    @NacosValue(value = "${test}", autoRefreshed = true)
    private String test;

}
