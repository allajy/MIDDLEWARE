package com.bxc.assemble.sharding.domain;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@EnableConfigurationProperties(ShardingDataSourceProperties.class)
@Data
public class ShardingDataSourceProperties {


    List<String> dataSource;

}
