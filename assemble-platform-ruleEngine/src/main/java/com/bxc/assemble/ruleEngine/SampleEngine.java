package com.bxc.assemble.ruleEngine;

import com.bxc.assemble.ruleEngine.api.IRuleEngine;
import com.bxc.assemble.ruleEngine.bean.RuleEngineModel;
import com.bxc.assemble.ruleEngine.api.impl.SampleRule;

import java.util.HashMap;
import java.util.Map;

public class SampleEngine {



    public static void main(String[] args) {
        RuleEngineModel ruleEngineModel = new RuleEngineModel("test");
        IRuleEngine iRuleEngine = RuleEngineContext.createRuleEngine(ruleEngineModel);
        RuleEngineContext.bindRule(ruleEngineModel,new SampleRule());
        Map<String,Object> param = new HashMap<>();
        param.put("p1","test");
        iRuleEngine.execute(param);
    }
}
