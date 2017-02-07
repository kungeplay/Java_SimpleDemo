package service;

import model.Student;

import java.util.Map;

/**
 * 验证Hessian序列化协议
 * Created by jiakun on 17-2-7.
 */
public interface HessianService {
    public Student constructStudent(String name, int age);
    public Student constructStudent(String name, int age, Map<String,Object> attachmets);
}
