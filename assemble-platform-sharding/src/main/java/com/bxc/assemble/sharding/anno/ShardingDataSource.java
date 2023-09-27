package com.bxc.assemble.sharding.anno;

/**
 * @project-name:standard-boot
 * @package-name:com.bxc.standard.sharding.anno
 * @description: mixed数据源信息控制
 */
public @interface ShardingDataSource {

    /**
     * 逻辑数据源名称
     * @return
     */
    String logicDataSourceName();

    /**
     * 开始配置机制控制
     */
    int startRangeNumber();

    /**
     * 结束范围机制控制
     */
    int endRangeNumber();

    /**
     * 兼容复杂模式下的处理
     */
    String shardingColumn();

}
