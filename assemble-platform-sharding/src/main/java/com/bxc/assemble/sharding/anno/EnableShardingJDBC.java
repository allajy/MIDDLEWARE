package com.bxc.assemble.sharding.anno;

import com.bxc.assemble.sharding.core.ShardingDataSourceConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Import({ShardingDataSourceConfiguration.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface EnableShardingJDBC {


}
