package com.bxc.assemble.eventbus.web;

import cn.hutool.extra.spring.SpringUtil;
import com.bxc.assemble.common.model.http.ResultResponse;
import com.bxc.assemble.eventbus.EventListenerRegistry;
import com.bxc.assemble.eventbus.disruptor.EventModel;
import com.bxc.assemble.eventbus.spring.SpringEventListenerRegistry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/eventbus")
@Api(value="事件驱动服务",tags = {"事件驱动服务组件"},description = "包含Disruptor、Spring 、Guava三种eventBus")
public class EventBusController {


    @Autowired
    Map<String,EventListenerRegistry> stringEventListenerRegistryMap;

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 创建对应的延时队列对象服务
     * @param event
     * @return
     */
    @PostMapping("/publish")
    @ApiOperation(value="发布事件",notes = "包含Disruptor、Spring 、Guava三种eventBus")
    public ResultResponse create(@RequestParam("driverType") String driverType, @RequestBody EventModel event){
        try {
            EventListenerRegistry eventListenerRegistry =
                    stringEventListenerRegistryMap.getOrDefault(driverType,
                            SpringUtil.getBean(SpringEventListenerRegistry.class));
            log.info("execute the driver class:{}",eventListenerRegistry.getClass().getName());
            eventListenerRegistry.publish(event);
            return ResultResponse.success(event);
        }catch (Exception e){
            log.error("publish event element is failure!",e);
            return ResultResponse.failure("publish event element is failure!");
        }
    }

    @PostMapping("/test")
    @ApiOperation(value="发布事件",notes = "测试事件发布！")
    public ResultResponse test(){
        try {
            applicationContext.publishEvent(new com.bxc.assemble.eventbus.model.EventModel("test"));
            return ResultResponse.success("event");
        }catch (Exception e){
            log.error("publish event element is failure!",e);
            return ResultResponse.failure("publish event element is failure!");
        }
    }






}
