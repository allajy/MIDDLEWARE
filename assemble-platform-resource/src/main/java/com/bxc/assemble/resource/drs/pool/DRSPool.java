package com.bxc.assemble.resource.drs.pool;


import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @class-name:DRSPoolHandler
 * @description:此类主要用于: 资源池的处理器机制
 */
public interface DRSPool<T> {


    AtomicInteger SEQ_INCR = new AtomicInteger(NumberUtils.BYTE_ZERO);



    String DEFAULT_POOL_NAME_PREFIX = "defaultDRSPool-";



    double DEFAULT_PERCENT_RESOURCE_VALUE = 1.0;

    /**
     * 添加资源
     * @param drs
     */
    boolean addResource(DRS<T> drs);

    /**
     * 获取相关的资源对象
     * @param drs
     * @return
     */
    DRS getResource(DRS<T> drs);

    /**
     *
     * @param drs
     * @return
     */
    double getResourceValue(DRS<T> drs);

    /**
     * 获取资源信息列表
     * @return
     */
    List<DRS<T>> getResourceList();

    /**
     * 删除资源
     * @return
     */
    boolean delResource(DRS<T> drs);

    /**
     * 获取当前使用资源数量
     * @return
     */
    double currentUsedResourceValue();

    /**
     * 获取当前仍然资源数量
     * @return
     */
    double currentRemainResourceValue();

}
