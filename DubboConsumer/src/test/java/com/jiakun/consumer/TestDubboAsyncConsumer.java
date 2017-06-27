package com.jiakun.consumer;

import com.jiakun.model.CallbackImpl;
import com.xuzhu.service.DubboAsyncService;
import com.xuzhu.service.DubboService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 编写dubbo的回调函数实例
 * Created by jiakun on 17-6-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application.xml"})
public class TestDubboAsyncConsumer {
    @Resource
    private DubboAsyncService dubboAsyncService;
    @Resource
    private DubboService dubboService;
    @Test
    public  void testAsync() {
        System.out.println("消费端开始异步调用");
        dubboAsyncService.doProcess("123", new CallbackImpl());
        System.out.println("同步调用结果:"+dubboService.getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
