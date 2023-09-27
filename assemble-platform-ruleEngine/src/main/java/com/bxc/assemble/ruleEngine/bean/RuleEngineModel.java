package com.bxc.assemble.ruleEngine.bean;

import lombok.Data;
import org.jeasy.rules.core.RulesEngineParameters;

@Data
public class RuleEngineModel {


    private String ruleEngineName;

    private RulesEngineParameters rulesEngineParameters;


    public RuleEngineModel(String ruleEngineName, RulesEngineParameters rulesEngineParameters) {
        this.ruleEngineName = ruleEngineName;
        this.rulesEngineParameters = rulesEngineParameters;
    }

    public RuleEngineModel(String ruleEngineName) {
        this.ruleEngineName = ruleEngineName;
        this.rulesEngineParameters = new RulesEngineParameters();
        rulesEngineParameters.setSkipOnFirstAppliedRule(Boolean.TRUE);
    }

    public static void main(String[] args) {

    }
}
