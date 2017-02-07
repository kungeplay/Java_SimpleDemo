package model;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiakun on 17-2-7.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -706924988271171351L;
    private String name;
    private int age;
    private List<String> hobbies = Lists.newArrayList();
    private List<String> duties = Lists.newArrayList();
    private List<String> feature=Lists.newArrayList();

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getDuties() {
        return duties;
    }

    public void setDuties(List<String> duties) {
        this.duties = duties;
    }

    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", hobbies=").append(hobbies);
        sb.append(", duties=").append(duties);
        sb.append(", feature=").append(feature);
        sb.append('}');
        return sb.toString();
    }
}
