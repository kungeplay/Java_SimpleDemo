package com.jiakun.consumer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xuzhu.model.Worker;
import com.xuzhu.service.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * Dubbo服务消费者
 * Created by xuzhu on 16-9-17.
 */
public class TestDubboConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"application.xml"});
        context.start();
        DubboService dubboService = (DubboService) context.getBean("dubboService");
        final long start = System.currentTimeMillis();
        try {
            System.out.println(dubboService.getName());
        }catch (Throwable e){
            System.out.println("one timeout:"+(System.currentTimeMillis()-start));
            e.printStackTrace();
        }
        Map<String, Object> attachments = Maps.newHashMap();
        attachments.put("hobbies", new String[]{"篮球", "足球", "网球"});
        attachments.put("duties", Sets.newHashSet("打扫卫生", "擦黑板"));
        attachments.put("feature", Lists.newArrayList("高个", "肤黑"));

        Worker worker=new Worker("刘洋",38);
        worker.setAttachments(attachments);
        long start2=System.currentTimeMillis();
        try {
            String s = dubboService.getDescribe(worker);
            System.out.println(s);
        }catch (Throwable e){
            System.out.println("two timeout:"+(System.currentTimeMillis()-start2));
            e.printStackTrace();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
