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
package com.bxc.assemble.eventbus.base;

import com.bxc.assemble.eventbus.EventListener;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseEventListener<T> implements EventListener<T> {


    @Override
    public String topic() {
        return null;
    }


    @org.springframework.context.event.EventListener
    @Override
    public void onMessage(T message) {
        onEvent(message);
    }


    protected abstract void onEvent(T message);

}
