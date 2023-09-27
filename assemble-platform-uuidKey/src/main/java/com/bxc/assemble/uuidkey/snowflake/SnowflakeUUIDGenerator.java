package com.bxc.assemble.uuidkey.snowflake;

import com.bxc.assemble.uuidkey.base.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
//@ConditionalOnExpression("'${uuidKey.type}'.equalsIgnoreCase('snowflake')")
@Service("snowflake")
public class SnowflakeUUIDGenerator implements UUIDGenerator<Long> {


    @Override
    public Long nextId() {
        Long id = IdGenerator.nextId();
        log.info("生成：{}",id);
        return id;
    }
}
