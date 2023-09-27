package com.bxc.assemble.resource.drs.enums;

/**
 * @project-name:lhy-report
 * @package-name:com.lhy.report.resource
 * @description: 动态数据资源配置类型
 */
public enum DRSDataType {

    /**
     * cpu调度层面资源：cpu使用层面：考虑采用线程池的限流或者令牌桶计算算法实现
     */
    CPU_THREAD,

    /**
     * memory调度层面资源：memory使用层面：考虑采用分配数量机制分配相关的算法使用机制
     */
    MEMORY_DATA_NUMBER,

}
