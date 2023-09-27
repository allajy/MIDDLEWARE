package com.bxc.assemble.scheduler.core;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleQuartzJob extends QuartzJob{

    @Override
    protected String cronExpression() {
        return "0/2 * * * * ?";
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("test:======");
    }
}
