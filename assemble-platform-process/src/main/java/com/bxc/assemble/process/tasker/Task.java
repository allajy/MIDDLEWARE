package com.bxc.assemble.process.tasker;

import java.io.Serializable;

public class Task implements Runnable, Serializable {
    @Override
    public void run() {
        System.out.println("execute task :{}" + System.currentTimeMillis());
    }
}
