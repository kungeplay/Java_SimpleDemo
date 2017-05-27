package com.jiakun.fresh.services;

/**
 * Created by jiakun on 17-5-23.
 */
public interface ServiceInterface<V,T,E> {
    V doProcess(T t,E e);
}
