package com.jiakun.fresh.pojo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jiakun on 17-5-5.
 */
public class MarkupResultTest {
    @Test
    public void readMarkupResultfromXML() throws IOException {
        InputStream is =MarkupResultTest.class.getClassLoader().getResourceAsStream("MarkupResult1.xml");
        XmlMapper xmlMapper = new XmlMapper();
        MarkupResult markupResult=xmlMapper.readValue(is, MarkupResult.class);
        System.out.println(markupResult);
        MarkupResult.MarkupItem markupItem = markupResult.getMarkupItems().get(0);
        System.out.println(markupItem.getMarkupBy().getDesc());
        is.close();
    }
}