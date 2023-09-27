package com.bxc.assemble.dynamicTask.alarm;


import com.bxc.assemble.dynamicTask.model.JobInfo;
import com.bxc.assemble.dynamicTask.model.JobLog;

/**
 * @author xuxueli 2020-01-19
 */
public interface JobAlarm {

    /**
     * job alarm
     *
     * @param info
     * @param jobLog
     * @return
     */
    public boolean doAlarm(JobInfo info, JobLog jobLog);

}
