package com.bxc.assemble.sharding.parser.wrapper;

import com.bxc.assemble.sharding.enums.ShardingModelType;
import com.bxc.assemble.sharding.parser.StrategyModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class StrategyModelWrapperAdapter implements StategyModelWrapper<ShardingModelType,StrategyModelParser>{


    @Autowired
    ApplicationContext applicationContext;

    /**
     * 自动化选择策略模式解析器
     * @return
     */
    @Override
    public StrategyModelParser autoSwitchStrategyModelParser(ShardingModelType shardingModelType){
        return applicationContext.getBean(shardingModelType.getCode(),StrategyModelParser.class);
    }

}
