package com.jiakun.fresh.services.impl;

import com.jiakun.fresh.pojo.Adult;
import com.jiakun.fresh.pojo.Child;
import com.jiakun.fresh.pojo.Family;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jiakun on 17-5-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/ApplicationContext.xml")
public class ServiceExampleTest {

    @Resource
    private ServiceExample serviceExample;

    @Test
    public void doProcess() throws Exception {
        Adult adult = new Adult("jiakun", 23);
        Child child = new Child("zhangsan", 12);
        Family family = (Family) serviceExample.doProcess(adult, child);
        if (family!=null){
            Assert.assertEquals(family.getAdult(),adult);
        }
    }

}