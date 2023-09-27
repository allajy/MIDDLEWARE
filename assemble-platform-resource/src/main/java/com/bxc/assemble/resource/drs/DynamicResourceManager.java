package com.bxc.assemble.resource.drs;


import com.bxc.assemble.resource.drs.enums.DRSAllocateType;
import com.google.common.util.concurrent.RateLimiter;
import com.bxc.assemble.resource.drs.pool.AbstractMemoryDRSPool;
import com.bxc.assemble.resource.drs.pool.DRS;
import com.bxc.assemble.resource.drs.pool.DRSPool;
import org.apache.commons.lang3.math.NumberUtils;

public class DynamicResourceManager {

    /**
     * long类型的资源池
     */
    public static class LongMemoryDRSPool extends AbstractMemoryDRSPool<Long> {}

    /**
     * String类型的资源池
     */
    public static class StringMemoryDRSPool extends AbstractMemoryDRSPool<String>{}

    /**
     * 资源信息数据处理控制
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> DRSPool<T> createDRSPool(T clazz){
        DRSPool drsPool = null;
        if(clazz instanceof Long){
            drsPool = new LongMemoryDRSPool();
        }
        if(clazz instanceof String){
            drsPool = new StringMemoryDRSPool();
        }
        return drsPool;
    }

    /**
     * 控制qps资源单位控制
     * @return
     */
    public static RateLimiter createQpsLimiter(DRSPool drsPool, DRS drs){
        double rateLimiterValue = drsPool.getResourceValue(drs);
        if(rateLimiterValue <= NumberUtils.DOUBLE_ZERO){
            return null;
        }
        return RateLimiter.create(rateLimiterValue);
    }


    public static void main(String[] args) {

        DRSPool drsPool = DynamicResourceManager.createDRSPool(new Long(0));
        drsPool.addResource(new DRS(1, DRSAllocateType.DRS,0.1));
        drsPool.addResource(new DRS(2, DRSAllocateType.DRS,0.1));
        System.out.println(drsPool.getResource(new DRS(1, DRSAllocateType.DRS,0.1)));
        System.out.println(drsPool.getResource(new DRS(2, DRSAllocateType.DRS,0.1)));
        System.out.println(drsPool.getResourceValue(new DRS(1, DRSAllocateType.DRS,0.1)));
        System.out.println(drsPool.getResourceValue(new DRS(2, DRSAllocateType.DRS,0.1)));
        System.out.println(drsPool.currentUsedResourceValue());
        System.out.println(drsPool.currentRemainResourceValue());
        System.out.println(drsPool.delResource(new DRS(2, DRSAllocateType.DRS,0.1)));
        System.out.println(drsPool.currentUsedResourceValue());
        System.out.println(drsPool.currentRemainResourceValue());
        System.out.println(1.0/3);

    }

}
