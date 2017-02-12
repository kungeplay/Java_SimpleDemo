package com.jiakun.service;

import com.xuzhu.model.Worker;
import com.xuzhu.service.DubboService;

/**
 * Dubbo服务提供者
 * Created by xuzhu on 16-9-17.
 */
public class DubboServiceImpl implements DubboService {
    //测试下dubbo的序列化和反序列化
    public String getDescribe(Worker worker) {
        return worker.toString();
    }

    public String getName() {
        return "刘佳坤!";
    }
}
