package com.bxc.assemble.sharding.model.mixed;

import com.bxc.assemble.sharding.model.inline.DataSourceInlineRangeStrategy;
import com.bxc.assemble.sharding.model.inline.InlineModelStrategy;
import com.bxc.assemble.sharding.model.inline.TableInlineRangeStrategy;
import com.bxc.assemble.sharding.enums.ShardingModelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.shardingsphere.api.config.sharding.strategy.ShardingStrategyConfiguration;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MixedModelStrategy extends InlineModelStrategy {

    /**
     * 分片策略模式:覆盖父类的
     */
    private ShardingModelType shardingModelType = ShardingModelType.MIXED;

    /**
     * 操作机制控制
     */
    private ShardingStrategyConfiguration shardingRuleConfiguration;



    public MixedModelStrategy(DataSourceInlineRangeStrategy dataSourceInlineRangeStrategy, TableInlineRangeStrategy tableInlineRangeStrategy, ShardingStrategyConfiguration shardingRuleConfiguration) {
        super(dataSourceInlineRangeStrategy, tableInlineRangeStrategy);
        this.shardingRuleConfiguration = shardingRuleConfiguration;
    }
}
