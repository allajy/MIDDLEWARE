package com.bxc.assemble.sharding.model.inline;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @project-name:standard-boot
 * @package-name:com.bxc.standard.sharding.model
 * @description: InLine模式策略机制
 */
@Accessors(chain = true)
@Data
public class InlineRangeStrategy {

    /**
     * 开始配置机制控制
     */
    private Integer startRangeNumber;

    /**
     * 结束范围机制控制
     */
    private Integer endRangeNumber;

    /**
     * 兼容复杂模式下的处理
     */
    private String shardingColumns;

    /**
     * 算法逻辑控制机制
     */
    private String algorithmExpression;

}
