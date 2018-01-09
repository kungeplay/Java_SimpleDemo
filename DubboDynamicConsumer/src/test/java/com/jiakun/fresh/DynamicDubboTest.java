package com.jiakun.fresh;

import com.alibaba.dubbo.config.ConsumerConfig;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.jiakun.fresh.dubbo.DubboConsumerService;
import com.jiakun.fresh.javaconfig.DynamicDubbo;
import com.xuzhu.model.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * 测试dubbo的注解注入
 *
 * @author jiakun.liu
 * @create 2017-12-27 下午3:23
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.jiakun.fresh.javaconfig.RootConfig.class)
public class DynamicDubboTest {
    @Resource
    private DubboConsumerService dubboConsumerService;
    @Test
    public void testDubbo(){
        ConsumerConfig consumerConfig=new ConsumerConfig();
        consumerConfig.setVersion("0.0.1");
        consumerConfig.setTimeout(3000);

        List<Map<String, Object>> parameters1 =Lists.newArrayList();

        Object result = dubboConsumerService.genericInvoke("com.xuzhu.service.DubboService", consumerConfig, "getName", parameters1);
        System.out.println(result.toString());

        Map<String, Object> attachments = Maps.newHashMap();
        attachments.put("hobbies", new String[]{"篮球", "足球", "网球"});
        attachments.put("duties", Sets.newHashSet("打扫卫生", "擦黑板"));
        attachments.put("feature", Lists.newArrayList("高个", "肤黑"));
//
        Worker worker=new Worker("刘洋",38);
        worker.setAttachments(attachments);
        List<Map<String, Object>> parameters =Lists.newArrayList();
        Map<String, Object> parameterMap=Maps.newHashMap();
        parameters.add(parameterMap);
        parameterMap.put("com.xuzhu.model.Worker",worker);

//        Object getDescribe = dubboConsumerService.genericInvoke("com.xuzhu.service.DubboService", configParams, "getDescribe", parameters);

//        long start2=System.currentTimeMillis();
//        try {
//            String s = dubboService.getDescribe(worker);
//            System.out.println(s);
//        }catch (Throwable e){
//            System.out.println("two timeout:"+(System.currentTimeMillis()-start2));
//            e.printStackTrace();
//        }
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("over");
    }

}
