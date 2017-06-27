package com.jiakun.service;

import com.xuzhu.model.Callback;
import com.xuzhu.service.DubboAsyncService;

import java.util.concurrent.TimeUnit;

/**
 * dubbo回调函数实例
 * Created by jiakun on 17-6-5.
 */
public class DubboAsyncServiceImpl implements DubboAsyncService {
    public void doProcess(String params, Callback callback) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始执行回调函数");
        try {
            callback.doInvoke(params);
        }catch (Exception e){//如果在回调还没有执行时consumer挂掉会走到这里
            System.out.println("执行回调函数过程中产生异常:"+e.getMessage());
        }
        System.out.println("回调函数执行完成");
    }
}
