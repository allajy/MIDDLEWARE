package com.bxc.assemble.sharding.model.inline;

import com.bxc.assemble.sharding.enums.ShardingModelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InlineModelStrategy {

    /**
     * 分片策略模式
     */
    private ShardingModelType shardingModelType = ShardingModelType.INLINE;

    /**
     * 数据眼内联区间策略模式
     */
    private  DataSourceInlineRangeStrategy dataSourceInlineRangeStrategy;

    /**
     * table名称区间策略机制控制
     */
    private  TableInlineRangeStrategy tableInlineRangeStrategy;

    /**
     * 构造器
     * @param dataSourceInlineRangeStrategy
     * @param tableInlineRangeStrategy
     */
    public InlineModelStrategy(DataSourceInlineRangeStrategy dataSourceInlineRangeStrategy, TableInlineRangeStrategy tableInlineRangeStrategy) {
        this.dataSourceInlineRangeStrategy = dataSourceInlineRangeStrategy;
        this.tableInlineRangeStrategy = tableInlineRangeStrategy;
    }
}
