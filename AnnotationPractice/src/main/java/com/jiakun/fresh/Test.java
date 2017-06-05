package com.jiakun.fresh;

import com.jiakun.fresh.annotation.MyDeprecated;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by jiakun on 17-5-27.
 */
public class Test {
    @MyDeprecated
    public String sayHelloWorld(){
        return "Hello World";
    }
    public String say(){
        return "Hi";
    }

    public static void main(String[] args) {
        testMyDeprecated(Test.class);
    }

    public static void testMyDeprecated(Class<?> cls){
        final Annotation[] annotations = cls.getAnnotations();
        for (Method method : cls.getMethods()) {
            MyDeprecated annotation = method.getAnnotation(MyDeprecated.class);
            if (annotation!=null){
                System.out.println("方法名:"+method.getName()+";注解:"+annotation.description());
            }
        }
    }
}
