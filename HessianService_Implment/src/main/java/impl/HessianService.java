package impl;

import model.Student;

import java.util.ArrayList;
import java.util.Map;

/**
 * 验证Hessian序列化协议 参考资料 http://blog.csdn.net/wodediqizhang/article/details/51605441
 * Created by jiakun on 17-2-7.
 */
public class HessianService implements service.HessianService {
    public Student constructStudent(String name, int age) {
        return new Student(name, age);
    }

    public Student constructStudent(String name, int age, Map<String, Object> attachmets) {
        Student student = new Student(name, age);
        //反序列化
        for (Map.Entry<String, Object> entry : attachmets.entrySet()) {
            if ("hobbies".equals(entry.getKey())) {
                try {
                    ArrayList<String> hobbies = (ArrayList<String>) entry.getValue();
                    student.setHobbies(hobbies);
                } catch (Exception e) {
                    System.out.println("获取hobbies出错：" + e);
                }
            } else if ("duties".equals(entry.getKey())) {
                try {
                    ArrayList<String> duties = (ArrayList<String>) entry.getValue();
                    student.setHobbies(duties);
                } catch (Exception e) {
                    System.out.println("获取duties出错：" + e);
                }
            }else if ("feature".equals(entry.getKey())){
                try {
                    ArrayList<String> feature=(ArrayList<String>) entry.getValue();
                    student.setFeature(feature);
                }catch (Exception e ){
                    System.out.println("获取feature出错:"+e);
                }
            }
        }
        return student;
    }
}
