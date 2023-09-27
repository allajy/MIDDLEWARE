package com.bxc.assemble.eventbus.model;

import org.springframework.context.ApplicationEvent;


@Deprecated
public class EventModel extends ApplicationEvent {

    public EventModel(Object source) {
        super(source);
    }

}
