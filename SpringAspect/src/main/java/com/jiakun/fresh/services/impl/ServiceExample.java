package com.jiakun.fresh.services.impl;

import com.jiakun.fresh.pojo.Adult;
import com.jiakun.fresh.pojo.Child;
import com.jiakun.fresh.pojo.Family;
import com.jiakun.fresh.services.ServiceInterface;
import org.springframework.stereotype.Service;

/**
 * Created by jiakun on 17-5-23.
 */
@Service
public class ServiceExample implements ServiceInterface<Family, Adult, Child> {

    public Family doProcess(Adult adult, Child child) {
        Family family = new Family(adult, child);
        return family;
    }
}
