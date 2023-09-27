package com.bxc.assemble.process.tasker;

import org.redisson.Redisson;
import org.redisson.RedissonExecutorService;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.redisson.executor.RedissonExecutorRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class SchedulerController {



    RedissonExecutorRemoteService executorRemoteService;


    RedissonExecutorService redissonExecutorService;


    @Autowired
    RedissonClient redissonClient;



    public void publicSchedulerTask(){
        RScheduledExecutorService scheduledExecutorService=
                redissonClient.getExecutorService("taskScheduler");
//        scheduledExecutorService.scheduleAtFixedRate(new Task(),1,3, TimeUnit.SECONDS);
        RScheduledFuture rScheduledFuture = scheduledExecutorService.schedule(new Task(),
                CronSchedule.of("* * * * * ?"));
        try {
            System.out.println(rScheduledFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    };


    public static void main(String[] args) {
        Config config=new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient client= Redisson.create(config);
        client.getExecutorService(RExecutorService.MAPREDUCE_NAME).registerWorkers(4);
        RScheduledExecutorService executorService=client.getExecutorService("es");
        executorService.schedule((Runnable & Serializable) ()->{
            System.out.println("hello world");
        },1, TimeUnit.SECONDS);
        System.out.println(executorService.getName());
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程运行结束");
    }
}
