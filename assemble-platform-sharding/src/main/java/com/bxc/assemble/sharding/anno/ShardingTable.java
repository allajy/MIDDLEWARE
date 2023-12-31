/**
 * Copyright [2019] [LiBo/Alex of copyright 171779852@qq.com ]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bxc.assemble.sharding.anno;


import com.google.common.base.Strings;

/**
 * @project-name:standard-boot
 * @package-name:com.bxc.standard.sharding.annotation
 * @author:LiBo/Alex
 * @create-date:2021-08-20 14:57
 * @copyright:libo-alex4java
 * @email:171779852@qq.com
 * @description:
 */
public @interface ShardingTable {

    /**
     * 逻辑表名称
     * @return
     */
    String logicTableName();

    /**
     * 开始配置机制控制
     */
    int startRangeNumber();

    /**
     * 结束范围机制控制
     */
    int endRangeNumber();

    /**
     * 兼容复杂模式下的处理
     */
    String shardingColumn();

    /**
     * 算法逻辑控制机制
     */
    String algorithmExpression() default "";

}
