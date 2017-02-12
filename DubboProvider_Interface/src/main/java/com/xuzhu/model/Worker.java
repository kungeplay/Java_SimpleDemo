package com.xuzhu.model;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jiakun on 17-2-9.
 */
public class Worker implements Serializable {
    private static final long serialVersionUID = 4757250923770543360L;
    private String name;
    private int age;
    Map<String, Object> attachments = Maps.newHashMap();

    public Worker(String name, int age) {
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

    public Map<String, Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, Object> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Worker{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", attachments=").append(attachments);
        sb.append('}');
        return sb.toString();
    }
}
