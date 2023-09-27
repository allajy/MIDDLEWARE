package com.bxc.assemble.resource.drs.pool;

import com.bxc.assemble.resource.drs.enums.DRSAllocateType;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @project-name:lhy-report
 * @package-name:com.lhy.report.resource
 * @description: 动态资源模型
 */
@SuppressWarnings("serial")
@Data
public class DRS<T> implements Serializable {

    /**
     * 唯一业务编码
     */
    private T identifyId;

    /**
     * 动态资源的名称
     */
    private String drsName;

    /**
     * 动态资源的类型
     */
    private DRSAllocateType drsType;

    /**
     * 权重计算的资源
     */
    private double weight = 1.0;

    /**
     * 资源占比
     */
    private double value;


    public DRS(T identifyId, String drsName, DRSAllocateType drsType, double weight, double value) {
        this.identifyId = identifyId;
        this.drsName = drsName;
        this.drsType = drsType;
        this.weight = weight;
        this.value = value;
    }

    public DRS(T identifyId, DRSAllocateType drsType, double value) {
        this.identifyId = identifyId;
        this.drsType = drsType;
        this.value = value;
    }

    public DRS(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DRS)) return false;
        DRS<?> drs = (DRS<?>) o;
        return getIdentifyId().equals(drs.getIdentifyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifyId());
    }
}
