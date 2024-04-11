package com.bxc.assemble.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Calendar;

/**
 * @author: Bixc
 * @date: 2023/10/31 13:41
 **/
public class RateLimiterDemo {
    public static void main(String[] args) {
//        // 首先创建一个限流器，参数代表每秒生成的令牌数
//        RateLimiter rateLimiter = RateLimiter.create(1);
//        // limiter.acquire以阻塞的方式获取令牌。
//        // 当然也可以通过tryAcquire(int permits, long timeout, TimeUnit unit)来设置等待超时时间的方式获取令牌，
//        // 如果超timeout为0，则代表非阻塞，获取不到立即返回
//        for (int i = 1; i < 10; i=i+2) {
//            double waitTime = rateLimiter.acquire(i);
//            System.out.println("curTime="+System.currentTimeMillis()+" acq:"+i+" waitTime:"+waitTime);
//        }
        
        RateLimiterDemo.testSmoothBursty();
        
    }

    /**
     * 模拟，多线程，消耗令牌
     * @param threadNum 线程数量
     * @param tokenNum 每个线程一次消耗的令牌数
     * @param count 获取几次令牌
     * @param r 限流对象
     */
    public static void getTokenByNewThread(int threadNum, int tokenNum, int count, RateLimiter r){
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < count; k++) {
                        System.out.println(Calendar.getInstance().getTime()+" "+Thread.currentThread().getName()+
                                " get tokens: "+r.acquire());
                    }
                }
            }).start();
        }
    }

    /**
     * 平滑突发限流，
     * 1、以固定的速率生成令牌
     * 2、RateLimiter使用令牌桶算法，会进行令牌的累积，如果获取令牌的频率比较低，则不会导致等待，直接获取令牌。
     * 3、RateLimiter在没有足够令牌发放时，采用滞后处理的方式，也就是前一个请求获取令牌所需等待的时间由下一次请求来承受，也就是代替前一个请求进行等待。
     */
    private static void testSmoothBursty() {
        RateLimiter r = RateLimiter.create(2);
        RateLimiterDemo.getTokenByNewThread(1,1,5,r);
    }
}
