package com.jiakun.csv;

import au.com.bytecode.opencsv.CSVReader;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * 功能:
 * Created by liujiakun on 16-10-25.
 */
public class CsvFileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvFileReader.class);
    private static int hotCityNums = 5;

    public Map<String, ArrayList<String>> parseFile(String srcFile) throws IOException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(srcFile), "GB2312"));
        List<String[]> allLines = reader.readAll();
        reader.close();
        HashMap<String, ArrayList<String>> context = Maps.newHashMapWithExpectedSize(allLines.size());
        Iterator<String[]> lineIterator = allLines.iterator();
        while (lineIterator.hasNext()) {
            String[] line = lineIterator.next();
            ArrayList<String> hotCitys = Lists.newArrayListWithExpectedSize(5);
            String route = line[0];
            for (int index = 1; index < line.length; index++) {
                hotCitys.add(line[index]);
            }
            while (hotCitys.size() != hotCityNums) {
                hotCitys.add("");
            }
            context.put(route, hotCitys);
            LOGGER.info("{}_{}",line, line.length);
        }
        return context;
    }
}
