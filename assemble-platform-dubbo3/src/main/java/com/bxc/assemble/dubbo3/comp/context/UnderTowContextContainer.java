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
package com.bxc.assemble.dubbo3.comp.context;

import io.undertow.Undertow;
import io.undertow.util.Headers;
import org.apache.dubbo.container.Container;

/**
 * @project-name:middleware
 * @package-name:com.bxc.assemble.dubbo3.comp.context
 * @author:LiBo/Alex
 * @create-date:2022-11-24 22:39
 * @copyright:libo-alex4java
 * @email:171779852@qq.com
 * @description:
 */
public class UnderTowContextContainer implements Container {


    public Undertow undertow = Undertow.builder().
            addHttpListener(8882,"127.0.0.1").
            setHandler(httpServerExchange -> {
                httpServerExchange.getResponseHeaders().add(
                        Headers.CONTENT_TYPE,"text/html;charset=utf-8");
                httpServerExchange.getResponseSender().send("hello , 这是UnderTow容器");
                if(httpServerExchange.getRequestPath().equalsIgnoreCase("/shutdown")){
                    stop();
                }

    }).build();


    @Override
    public void start() {
        undertow.start();
    }

    @Override
    public void stop() {
        undertow.stop();
    }
}
