package com.jiakun.fresh.javaconfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jiakun.liu
 * @create 2017-12-27 上午11:40
 **/
@Configuration
@ComponentScan(basePackages ={"com.jiakun.fresh.dubbo"} )
public class DynamicDubbo {

    @Bean
    public ApplicationConfig applicationConfig() {//当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dynamic-dubbo");
        applicationConfig.setLogger("slf4j");
        applicationConfig.setOwner("jiakun.liu");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {//连接
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
//        registryConfig.setClient("fdfd");//todo
        registryConfig.setProtocol("zookeeper");
        registryConfig.setGroup("test");
        return registryConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig(){
        ConsumerConfig consumerConfig=new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        return consumerConfig;
    }

//    @Bean
//    public AnnotationBean annotationBean() {
//        AnnotationBean annotationBean = new AnnotationBean();
//        return annotationBean;
//    }
//
//    @Bean
//    public ProtocolConfig protocolConfig() {//服务提供者协议配置
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        return protocolConfig;
//    }

}
