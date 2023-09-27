package com.bxc.assemble.sharding.parser;

/**
 * @project-name:standard-boot
 * @package-name:com.bxc.standard.sharding.parser
 * @description: 策略模型解析器
 */
@FunctionalInterface
public interface StrategyModelParser<P,R>{

    /**
     * 解析器
     * @param param
     * @return
     */
    R parser(P param);

}
