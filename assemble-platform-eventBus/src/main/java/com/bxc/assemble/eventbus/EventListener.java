package com.bxc.assemble.eventbus;

public interface EventListener<T>{

    String topic();

    void onMessage(T message);

}
