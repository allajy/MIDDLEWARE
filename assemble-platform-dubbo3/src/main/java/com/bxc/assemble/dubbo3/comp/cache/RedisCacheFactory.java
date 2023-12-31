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
package com.bxc.assemble.dubbo3.comp.cache;

import org.apache.dubbo.cache.Cache;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;

/**
 * @project-name:assemble
 * @package-name:com.bxc.assemble.dubbo3.comp.cache
 * @author:LiBo/Alex
 * @create-date:2022-06-09 22:56
 * @copyright:libo-alex4java
 * @email:171779852@qq.com
 * @description:
 */
public class RedisCacheFactory implements org.apache.dubbo.cache.CacheFactory{

    @Override
    public Cache getCache(URL url, Invocation invocation) {
        System.out.println("-----------------------------------------"+url+"-----");
        return new RedisCache();
    }
}
