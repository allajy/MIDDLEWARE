package com.bxc.assemble.sharding.model.inline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class TableInlineRangeStrategy extends InlineRangeStrategy{

    /**
     * 逻辑表名称信息
     */
    private String logicTableName;

}
