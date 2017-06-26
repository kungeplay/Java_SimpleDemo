package com.jiakun.service;

import com.xuzhu.model.Callback;
import com.xuzhu.service.DubboAsyncService;

import java.util.concurrent.TimeUnit;

/**
 * dubbo回调函数实例
 * 此处发现一个问题，如果在provider还没有调用回调函数时，consumer就已经结束则会导致provider一直挂起状态。
 * Created by jiakun on 17-6-5.
 */
public class DubboAsyncServiceImpl implements DubboAsyncService {
    public void doProcess(String params, Callback callback) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始执行回调函数");
        callback.doInvoke(params);
        System.out.println("回调函数执行完成");
    }
}
