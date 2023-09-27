package com.bxc.assemble.uuidkey.base;

@FunctionalInterface
public interface UUIDGenerator<T> {



    T nextId();


}
