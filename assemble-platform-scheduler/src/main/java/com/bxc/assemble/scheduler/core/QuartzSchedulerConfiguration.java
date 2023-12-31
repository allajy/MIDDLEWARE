package com.bxc.assemble.scheduler.core;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;


@Configuration
public class QuartzSchedulerConfiguration implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private QuartzSchedulerHandler schedulerHandler;


    @Bean
    public QuartzSchedulerHandler quartzSchedulerHandler(){
        return new QuartzSchedulerHandler();
    }

    /**
     * 初始启动quartz
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            schedulerHandler.launcherJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始注入scheduler
     * @return
     * @throws SchedulerException
     */
    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
        return schedulerFactoryBean.getScheduler();
    }

}
