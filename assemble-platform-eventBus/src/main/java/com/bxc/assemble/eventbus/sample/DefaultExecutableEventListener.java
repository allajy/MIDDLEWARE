package com.bxc.assemble.eventbus.sample;

import com.bxc.assemble.eventbus.ExecutableEventListener;
import com.bxc.assemble.eventbus.disruptor.EventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultExecutableEventListener extends ExecutableEventListener {

    @Override
    public void handle(EventModel message) {
        log.info("{}",message);
    }

    @Override
    public String topic() {
        return "default";
    }
}
