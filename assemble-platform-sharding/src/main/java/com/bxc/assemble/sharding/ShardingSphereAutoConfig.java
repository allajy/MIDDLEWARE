package com.bxc.assemble.sharding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShardingSphereAutoConfig {

    @Bean
    public MonthTableShardingAlgorithm monthTableShardingAlgorithm(){
        MonthTableShardingAlgorithm monthTableShardingAlgorithm = new MonthTableShardingAlgorithm();
        return monthTableShardingAlgorithm;
    }
}
