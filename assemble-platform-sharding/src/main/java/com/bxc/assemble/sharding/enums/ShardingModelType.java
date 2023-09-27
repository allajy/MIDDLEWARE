package com.bxc.assemble.sharding.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ShardingModelType {

    /**
     * 内联模式
     */
    INLINE("inlineStringFormatModelParser",new String[]{"%s_${%d..%d}",".","%s_${%d..%d}"}),

    /**
     * 混合模式
     */
    MIXED("inlineStringFormatModelParser",new String[]{"%s_${%d..%d}",".","%s_${%d..%d}"}),

    /**
     * 多值模式
     */
    MULTIX("inlineStringFormatModelParser",new String[0]);

    /**
     * 编码 ：解析器暂时不分家：都采用内联方式的解析器机制
     */
    private String code;

    /**
     * 数值
     */
    private String[] value;

}
