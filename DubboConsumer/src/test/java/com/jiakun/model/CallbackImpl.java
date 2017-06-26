package com.jiakun.model;

import com.xuzhu.model.Callback;

/**
 * 编写dubbo的回调函数实例
 * Created by jiakun on 17-6-5.
 */
public class CallbackImpl implements Callback {
    public void doInvoke(String param) {
        System.out.println("回调函数中打印参数："+param);
    }
}
