package com.jiakun.consumer;

import com.xuzhu.service.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Dubbo服务消费者
 * Created by xuzhu on 16-9-17.
 */
public class TestDubboConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"application.xml"});
        context.start();
        DubboService dubboService = (DubboService)context.getBean("dubboService");
        System.out.println(dubboService.getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
