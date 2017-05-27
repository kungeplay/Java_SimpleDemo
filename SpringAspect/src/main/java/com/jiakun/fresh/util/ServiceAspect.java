package com.jiakun.fresh.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by jiakun on 17-5-23.
 */
@Component//声明这是一个组件
@Aspect//声明这是一个切面
public class ServiceAspect {
    //配置环绕通知
    @Around(value = "execution(* com.jiakun.fresh.services.impl.*.*(..))")
    public Object testAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        try {
            Object[] args = proceedingJoinPoint.getArgs();
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("得到执行");
            return proceed;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
