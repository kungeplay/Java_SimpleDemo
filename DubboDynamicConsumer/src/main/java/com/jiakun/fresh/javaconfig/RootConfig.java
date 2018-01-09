package com.jiakun.fresh.javaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * ContextLoaderListener上下文配置根文件，将两个或更多的装配类或XML文件组合起来.
 *
 * @author jiakun.liu
 * @create 2017-12-27 上午11:32
 **/
@Configuration
@Import(DynamicDubbo.class)
public class RootConfig {
}
