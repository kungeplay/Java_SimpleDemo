package com.xuzhu.service;

/**
 * Dubbo提供者提供的服务接口,单独打包提供给消费者。被消费者引用
 * Created by xuzhu on 16-9-17.
 */
public interface DubboService {
    public String getName();
}
