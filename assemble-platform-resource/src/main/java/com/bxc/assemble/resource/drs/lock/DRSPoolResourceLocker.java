package com.bxc.assemble.resource.drs.lock;

import java.util.concurrent.TimeUnit;

public interface DRSPoolResourceLocker<T> {

    boolean lock(T key);

    boolean lock(T key, long timeout, TimeUnit timeUnit);

    boolean unLock(T key);

    boolean unLock(T key, long timeout, TimeUnit timeUnit);

}
