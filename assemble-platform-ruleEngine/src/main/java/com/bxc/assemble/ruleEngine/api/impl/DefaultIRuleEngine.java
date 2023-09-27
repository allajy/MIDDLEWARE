package com.bxc.assemble.ruleEngine.api.impl;

import com.bxc.assemble.ruleEngine.api.IRule;
import com.bxc.assemble.ruleEngine.api.IRuleEngine;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultIRuleEngine implements IRuleEngine {


    private AtomicReference<Rules> rulesAtomicReference  = new AtomicReference<>(new Rules());


    private AtomicReference<RulesEngine> rulesEngineAtomicReference  = new AtomicReference<>();


    /**
     * 初始化相关的规则引擎
     * @param ruleEngineName
     * @param rulesEngineParameters
     * @return
     */
    @Override
    public RulesEngine initRuleEngine(String ruleEngineName, RulesEngineParameters rulesEngineParameters) {
        rulesEngineAtomicReference.set(new DefaultRulesEngine(rulesEngineParameters));
        return rulesEngineAtomicReference.get();
    }

    /**
     * 操作参数控制
     * @param parameter
     * @return
     */
    @Override
    public RulesEngine execute(Map<String, Object> parameter) {
        Facts facts = new Facts();
        facts.put("paramCondition",parameter);
        rulesEngineAtomicReference.get().fire(rulesAtomicReference.get(),facts);
        return rulesEngineAtomicReference.get();
    }

    /**
     * 获取相关的规则信息对象
     * @return
     */
    @Override
    public Rules getRules() {
        return rulesAtomicReference.get();
    }

    /**
     * 添加规则
     * @param iRule
     * @return
     */
    @Override
    public IRuleEngine addRule(IRule... iRule) {
        Arrays.stream(iRule).forEach(param->{
            getRules().register(param);
        });
        return this;
    }

    /**
     * 添加规则集合
     * @param iRuleList
     * @return
     */
    @Override
    public IRuleEngine addRules(List<IRule> iRuleList) {
        iRuleList.stream().forEach(param->{
            getRules().register(param);
        });
        return this;
    }


    /**
     * 删除规则
     * @param iRule
     * @return
     */
    @Override
    public IRuleEngine removeRule(IRule... iRule) {
        Arrays.stream(iRule).forEach(param->{
            getRules().unregister(param);
        });
        return this;
    }

    /**
     * 删除规则
     * @param iRuleList
     * @return
     */
    @Override
    public IRuleEngine removeRules(List<IRule> iRuleList) {
        iRuleList.stream().forEach(param->{
            getRules().unregister(param);
        });
        return this;
    }


    @Override
    public IRuleEngine removeRules(String... ruleNames) {
        Arrays.stream(ruleNames).forEach(param->{
            getRules().unregister(param);
        });
        return this;
    }

    @Override
    public IRuleEngine removeRules(Set<String> ruleNames) {
        ruleNames.stream().forEach(param->{
            getRules().unregister(param);
        });
        return this;
    }

}
