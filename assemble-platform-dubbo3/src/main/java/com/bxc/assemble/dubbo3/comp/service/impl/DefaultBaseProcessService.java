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
package com.bxc.assemble.dubbo3.comp.service.impl;

import com.bxc.assemble.dubbo3.comp.service.BaseProcessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @project-name:assemble
 * @package-name:com.bxc.assemble.dubbo3.comp.api
 * @author:LiBo/Alex
 * @create-date:2022-06-06 13:38
 * @copyright:libo-alex4java
 * @email:171779852@qq.com
 * @description:
 */
@Slf4j
public class DefaultBaseProcessService implements BaseProcessService<Object,Object> {


    @Override
    public Object process(Object param) {
        log.info("执行相关的 default base process service 的process方法:参数：{}",RpcContext.getContext().getAttachment("param"));
        return param;
    }
}
