package com.bxc.assemble.resource.drs.enums;

/**
 * @project-name:lhy-report
 * @package-name:com.lhy.report.resource
 * @description: 动态数据资源配置类型
 */
public enum DRSAllocateType {

    /**
     * 哈希轮询分配
     */
    HASH,

    /**
     * 绝对资源分配
     */
    AVG,

    /**
     * 动态资源调度
     */
    DRS,

    /**
     * 随机资源调度
     */
    RANDOM,

    /**
     * 自动适配调度
     */
    AUTOMIC,

    ;
}
