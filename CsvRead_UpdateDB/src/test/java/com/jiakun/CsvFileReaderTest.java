package com.jiakun;

import com.jiakun.csv.CsvFileReader;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 功能:
 * Created by liujiakun on 16-10-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class CsvFileReaderTest {
    @Autowired
    private CsvFileReader reader;

    @org.junit.Test
    public void testParseFile() throws Exception {
        String srcFileName="/tmp/国际中转点-修改20161024.csv";
        reader.parseFile(srcFileName);
    }

}