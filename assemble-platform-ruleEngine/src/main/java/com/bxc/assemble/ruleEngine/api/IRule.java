package com.bxc.assemble.ruleEngine.api;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;

import java.util.Map;


public interface IRule{

    /**
     * 符合条件参数控制
     * @param paramCondition
     * @return
     */
    boolean condition(Map<String,Object> paramCondition);

    /**
     * 执行处理操作控制
     * @param paramCondition
     */
    void process(Map<String,Object> paramCondition);

    /**
     * 优先级操作处理
     * @return
     */
    int getPriority();
}
