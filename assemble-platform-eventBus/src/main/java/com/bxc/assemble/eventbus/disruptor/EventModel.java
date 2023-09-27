package com.bxc.assemble.eventbus.disruptor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @project-name:lhy-report
 * @package-name:com.lhy.lhy.report.event
 * @description: 事件(Event)就是通过 Disruptor 进行交换的数据类型。
 */
@NoArgsConstructor
@Data
@SuppressWarnings("all")
@ApiModel(value="事件驱动模型")
public class EventModel<T> implements Serializable {

    @ApiModelProperty(value="事件发布主题",name="事件发布主题")
    private String topic;

    @ApiModelProperty(value="事件对象模型",name="事件对象模型")
    private T entity;

}
