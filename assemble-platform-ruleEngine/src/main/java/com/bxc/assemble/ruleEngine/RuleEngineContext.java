package com.bxc.assemble.ruleEngine;

import com.bxc.assemble.ruleEngine.api.IRule;
import com.bxc.assemble.ruleEngine.api.IRuleEngine;
import com.bxc.assemble.ruleEngine.api.impl.DefaultIRuleEngine;
import com.bxc.assemble.ruleEngine.bean.RuleEngineModel;
import com.google.common.collect.Maps;

import java.util.Map;

public class RuleEngineContext {


    /**
     * 容器规则
     */
    private static final Map<String, IRuleEngine> rulesEngineMap = Maps.newConcurrentMap();


    /**
     * 创建规则引擎
     * @param ruleEngineModel
     * @param defaultEngine
     * @param className
     * @return
     */
    public static IRuleEngine createRuleEngine(RuleEngineModel ruleEngineModel, boolean defaultEngine, String className){
        if(defaultEngine){
            IRuleEngine iRuleEngine = new DefaultIRuleEngine();
            iRuleEngine.initRuleEngine(ruleEngineModel.getRuleEngineName(),
                    ruleEngineModel.getRulesEngineParameters());
            rulesEngineMap.putIfAbsent(ruleEngineModel.getRuleEngineName(),iRuleEngine);
            return iRuleEngine;
        }
        return null;
    }

    /**
     * 创建规则引擎
     * @param ruleEngineModel
     * @return
     */
    public static IRuleEngine createRuleEngine(RuleEngineModel ruleEngineModel){
        return createRuleEngine(ruleEngineModel,Boolean.TRUE,null);
    }

    /**
     * 绑定规则
     * @param ruleEngineModel
     * @param ruleObjects
     * @return
     */
    public static IRuleEngine bindRule(RuleEngineModel ruleEngineModel, IRule... ruleObjects){
        return rulesEngineMap.get(ruleEngineModel.getRuleEngineName()).addRule(ruleObjects);
    }


    /**
     * 解绑规则
     * @param ruleEngineModel
     * @param ruleObjects
     * @return
     */
    public static IRuleEngine unbindRule(RuleEngineModel ruleEngineModel, IRule... ruleObjects){
        return rulesEngineMap.get(ruleEngineModel.getRuleEngineName()).addRule(ruleObjects);
    }





}
