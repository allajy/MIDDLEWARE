package com.bxc.assemble.sharding.parser;

import com.bxc.assemble.sharding.enums.ShardingModelType;
import com.bxc.assemble.sharding.model.inline.DataSourceInlineRangeStrategy;
import com.bxc.assemble.sharding.model.inline.InlineModelStrategy;
import com.bxc.assemble.sharding.model.inline.TableInlineRangeStrategy;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.StringJoiner;

public class InlineStringFormatModelParser implements StringFormatModelParser<InlineModelStrategy> {

    /**
     * 解析操作控制处理
     * @param param
     * @return
     */
    @Override
    public String parser(InlineModelStrategy param) {
        StringJoiner templateResult = new StringJoiner("");
        adjustDataSourceInlineRangeStrategy(templateResult,param.getDataSourceInlineRangeStrategy());
        adjustTableInlineRangeStrategy(templateResult,param.getTableInlineRangeStrategy());
        return templateResult.toString();
    }


    /**
     * 适配调整相关的数据源内联模式的区间处理策略机制
     */
    private void adjustDataSourceInlineRangeStrategy(StringJoiner templateResult, DataSourceInlineRangeStrategy dataSourceInlineRangeStrategy){
        // 第一层校验
        Objects.requireNonNull(dataSourceInlineRangeStrategy,"不允许传入的数据源数据对象为空");
        Preconditions.checkArgument(StringUtils.
                isNotBlank(dataSourceInlineRangeStrategy.getLogicDataSourceName()),"不允许传入空的数据源连接信息");
        // 如果前置或者后置数据信息为空
        String[] template = ShardingModelType.INLINE.getValue();
        if(Objects.isNull(dataSourceInlineRangeStrategy.getStartRangeNumber()) ||
                Objects.isNull(dataSourceInlineRangeStrategy.getEndRangeNumber())){
            templateResult.add(dataSourceInlineRangeStrategy.getLogicDataSourceName());
        }else{
            templateResult.add(String.format(template[0],dataSourceInlineRangeStrategy.getLogicDataSourceName(),
                    dataSourceInlineRangeStrategy.getStartRangeNumber(),dataSourceInlineRangeStrategy.getEndRangeNumber()));
        }
        templateResult.add(template[1]);
    }


    /**
     * 适配调整相关的逻辑表内联模式的区间处理策略机制
     */
    private void adjustTableInlineRangeStrategy(StringJoiner templateResult, TableInlineRangeStrategy tableInlineRangeStrategy){
        Objects.requireNonNull(tableInlineRangeStrategy,"不允许传入的逻辑表名数据对象为空");
        Preconditions.checkArgument(StringUtils.
                isNotBlank(tableInlineRangeStrategy.getLogicTableName()),"不允许传入空的逻辑表数据信息");
        // 如果前置或者后置数据信息为空
        String[] template = ShardingModelType.INLINE.getValue();
        if(Objects.isNull(tableInlineRangeStrategy.getStartRangeNumber()) ||
                Objects.isNull(tableInlineRangeStrategy.getEndRangeNumber())){
            templateResult.add(tableInlineRangeStrategy.getLogicTableName());
        }else{
            templateResult.add(String.format(template[2],tableInlineRangeStrategy.getLogicTableName(),
                    tableInlineRangeStrategy.getStartRangeNumber(),tableInlineRangeStrategy.getEndRangeNumber()));
        }
    }

}
