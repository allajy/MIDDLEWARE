package com.bxc.assemble.eventbus;

import com.bxc.assemble.eventbus.base.BaseEventListener;
import com.bxc.assemble.eventbus.model.EventModel;

//@Component
public class ModelEventListener extends BaseEventListener<EventModel> {

    @Override
    protected void onEvent(EventModel message) {
        System.out.println("---{}"+message);
    }
}
