package com.bxc.assemble.ruleEngine.api.impl;

import com.bxc.assemble.ruleEngine.api.IRule;
import org.jeasy.rules.annotation.*;

import java.util.Map;

@Rule(priority = 0,name = "sampleRule",description = "trest rule")
public class SampleRule implements IRule {


    @Condition
    @Override
    public boolean condition(@Fact("paramCondition") Map<String, Object> paramCondition) {
        System.out.println("condition-"+paramCondition);
        return Boolean.TRUE;
    }


    @Action
    @Override
    public void process(@Fact("paramCondition") Map<String, Object> paramCondition) {
        System.out.println("asda-"+paramCondition);
    }

    @Priority
    @Override
    public int getPriority() {
        return 0;
    }
}
