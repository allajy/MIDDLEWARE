package com.bxc.assemble.uuidkey.hutool;


import com.bxc.assemble.uuidkey.base.UUIDGenerator;
import org.springframework.stereotype.Service;

@Service("hutool")
//@ConditionalOnExpression("'${uuidKey.type}'.equalsIgnoreCase('hutool')")
public class HutoolUUIDGenerator implements UUIDGenerator<String> {


    static cn.hutool.core.lang.generator.UUIDGenerator  generator =  new cn.hutool.core.lang.generator.UUIDGenerator();


    @Override
    public String nextId() {
        return generator.next();
    }


}
