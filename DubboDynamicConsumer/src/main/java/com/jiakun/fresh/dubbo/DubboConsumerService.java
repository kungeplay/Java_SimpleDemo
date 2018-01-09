package com.jiakun.fresh.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jiakun.liu
 * @create 2017-12-27 下午3:07
 **/
@Component
public class DubboConsumerService {

    @Resource
    private ApplicationConfig applicationConfig;
    @Resource
    private RegistryConfig registryConfig;



    //注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
    // 引用远程服务
    //此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
    public Object genericInvoke(String interfaceClass, ConsumerConfig configParams, String methodName, List<Map<String, Object>> parameters){

        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(interfaceClass); // 接口名
        reference.setGeneric(true); // 声明为泛化接口
        reference.setConsumer(configParams);
        /*ReferenceConfig实例很重，封装了与注册中心的连接以及与提供者的连接，
        需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏。
        这里使用dubbo内置的简单缓存工具类进行缓存*/
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用

        int len = parameters.size();
        String[] invokeParamTyeps = new String[len];
        Object[] invokeParams = new Object[len];
        for(int i = 0; i < len; i++){
            invokeParamTyeps[i] = parameters.get(i).get("ParamType") + "";
            invokeParams[i] = parameters.get(i).get("Object");
        }
        return genericService.$invoke(methodName, invokeParamTyeps, invokeParams);
    }
}
