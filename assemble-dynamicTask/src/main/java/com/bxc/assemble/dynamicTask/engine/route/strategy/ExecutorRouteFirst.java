package com.bxc.assemble.dynamicTask.engine.route.strategy;


import com.bxc.assemble.dynamicTask.domain.ReturnT;
import com.bxc.assemble.dynamicTask.domain.TriggerParam;
import com.bxc.assemble.dynamicTask.engine.route.ExecutorRouter;

import java.util.List;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteFirst extends ExecutorRouter {

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList){
        return new ReturnT<String>(addressList.get(0));
    }

}
