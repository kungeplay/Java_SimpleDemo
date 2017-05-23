package com.jiakun.fresh.pojo;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jiakun on 17-5-5.
 */
public class EmployeeTest {
    //根据javabean类信息解析成javabean
    @Test
    public void readSimpleDatafromXML() throws IOException {
        String xmlPath="/home/jiakun/Git/Git_Hub/Java_SimpleDemo/XmlParse/target/classes/SimpleEmployee.xml";
        InputStream is = new FileInputStream(new File(xmlPath));
        XmlMapper xmlMapper = new XmlMapper();
        JavaType javaType=xmlMapper.getTypeFactory().constructType(Employee.class);
        Employee employee=xmlMapper.readValue(is,javaType);
        System.out.println(employee);
        is.close();
    }
}