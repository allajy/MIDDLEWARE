package com.bxc.assemble.sharding.parser.wrapper;

@FunctionalInterface
public interface StategyModelWrapper<P,R> {

    R autoSwitchStrategyModelParser(P paramType);

}
