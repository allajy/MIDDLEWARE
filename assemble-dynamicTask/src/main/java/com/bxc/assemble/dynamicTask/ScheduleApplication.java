package com.bxc.assemble.dynamicTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ScheduleApplication {

//    @XxlJob("demoJobHandler")
//    public void demoJobHandler() throws Exception {
//        XxlJobHelper.log("XXL-JOB, Hello World.");
//
//        for (int i = 0; i < 5; i++) {
//            XxlJobHelper.log("beat at:" + i);
//            TimeUnit.SECONDS.sleep(2);
//        }
//        // default success
//    }
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class,args);
    }
}
