/**
 * Copyright [2020] [LiBo/Alex of copyright 171779852@qq.com ]
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
package com.bxc.assemble.dubbo3.comp.anno.provider1;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @project-name:assemble-platform
 * @package-name:com.bxc.assemble.dubbo3.comp.anno
 * @author:LiBo/Alex
 * @create-date:2022-06-06 21:27
 * @copyright:libo-alex4java
 * @email:171779852@qq.com
 * @description:
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.bxc.assemble.dubbo3.comp.anno.provider1")
@PropertySource("classpath:dubbo-provider1.properties")
@ComponentScan(value = {"com.bxc.assemble.dubbo3.comp.anno.provider1"})
public class AnnotationProviderBootstrap {
}
