package com.bxc.assemble.ruleEngine.api;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRuleEngine {

    /**
     * 初始化相关的RuleEngine
     * @param ruleEngineName
     * @param rulesEngineParameters
     * @return
     */
    RulesEngine initRuleEngine(String ruleEngineName,RulesEngineParameters rulesEngineParameters);

    /**
     * 执行规则处理方式
     * @param parameter
     * @return
     */
    RulesEngine execute( Map<String,Object> parameter);

    /**
     * 获取相关的rule对象服务机制
     * @return
     */
    Rules getRules();

    /**
     * 添加规则执行器
     * @param iRule
     * @return
     */
    IRuleEngine addRule(IRule... iRule);

    /**
     * 添加规则执行器
     * @param iRuleList
     * @return
     */
    IRuleEngine addRules(List<IRule> iRuleList);

    /**
     * 删除规则执行器
     * @param iRule
     * @return
     */
    IRuleEngine removeRule(IRule... iRule);

    /**
     * 删除规则执行器
     * @param iRuleList
     * @return
     */
    IRuleEngine removeRules(List<IRule> iRuleList);

    /**
     * 删除规则执行器
     * @param ruleNames
     * @return
     */
    IRuleEngine removeRules(String... ruleNames);

    /**
     * 删除规则执行器
     * @param ruleNames
     * @return
     */
    IRuleEngine removeRules(Set<String> ruleNames);

}
