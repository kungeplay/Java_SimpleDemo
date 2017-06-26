package com.xuzhu.service;

import com.xuzhu.model.Callback;

/**
 * Created by jiakun on 17-6-5.
 */
public interface DubboAsyncService {
    void doProcess(String params, Callback callback);
}
