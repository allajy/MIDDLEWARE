package com.bxc.assemble.ratelimiter.sample;

import com.bxc.assemble.ratelimiter.guava.annotation.GuavaExecuteRateLimiter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SampleExecuteRateLimiter {


    @SneakyThrows
    @GuavaExecuteRateLimiter(permitsPerSecond=5)
    public void executeRateLimiter(int processTime){
        TimeUnit.SECONDS.sleep(processTime);
    }

}
