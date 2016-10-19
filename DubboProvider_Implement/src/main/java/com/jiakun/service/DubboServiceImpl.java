package com.jiakun.service;

import com.xuzhu.service.DubboService;

/**
 * Dubbo服务提供者
 * Created by xuzhu on 16-9-17.
 */
public class DubboServiceImpl implements DubboService {
    public String getName() {
        return "刘佳坤!";
    }
}
