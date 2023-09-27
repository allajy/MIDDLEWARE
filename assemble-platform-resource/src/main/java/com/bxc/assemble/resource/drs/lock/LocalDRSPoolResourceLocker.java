package com.bxc.assemble.resource.drs.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LocalDRSPoolResourceLocker implements DRSPoolResourceLocker<Object>{



    Lock lock = new ReentrantLock();

    /**
     * 加锁
     * @param key
     * @return
     */
    @Override
    public boolean lock(Object key) {
        return lock.tryLock();
    }

    /**
     * 加锁
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    @Override
    public boolean lock(Object key, long timeout, TimeUnit timeUnit) {
        try {
            return lock.tryLock(timeout,timeUnit);
        } catch (InterruptedException e) {
            log.error("lock is abort!",e);
            return false;
        }
    }

    /**
     * 解锁
     * @param key
     * @return
     */
    @Override
    public boolean unLock(Object key) {
        try {
            lock.unlock();
            return Boolean.TRUE;
        }catch (Exception e){
            log.error("unlock is failure!",e);
            return Boolean.FALSE;
        }
    }

    /**
     * 解锁
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    @Override
    public boolean unLock(Object key, long timeout, TimeUnit timeUnit) {
        try {
            lock.unlock();
            return Boolean.TRUE;
        }catch (Exception e){
            log.error("unlock is failure!",e);
            return Boolean.FALSE;
        }
    }
}
