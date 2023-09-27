package com.bxc.assemble.scheduler.core;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public abstract class QuartzJob implements Job {


    protected abstract String cronExpression();

}
