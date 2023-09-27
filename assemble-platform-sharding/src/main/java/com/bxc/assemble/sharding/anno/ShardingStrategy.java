package com.bxc.assemble.sharding.anno;

import com.bxc.assemble.sharding.enums.ShardingModelType;
import com.bxc.assemble.sharding.core.MixedShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @project-name:standard-boot
 * @package-name:com.bxc.standard.sharding.annotation
 * @description: 分片信息表
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Component
@Autowired(required = false)
@Qualifier("shardingStrategy")
public @interface ShardingStrategy {

    /**
     * 分片分表的模式机制
     * @return
     */
    ShardingModelType shardingModelType() default ShardingModelType.MIXED;

    /**
     * 分片表机制
     * @return
     */
    ShardingTable shardingTable();

    /**
     * 分片数据源机制
     * @return
     */
    ShardingDataSource shardingDataSource();

    /**
     * 只有在mix模式下才会有效果
     * @return
     */
    Class<? extends ShardingStrategyConfiguration> defaultShardingStrategyConfiguration() default
            MixedShardingStrategyConfiguration.class;

}
