package com.jiakun.fresh.service;

import com.jiakun.fresh.pojo.BookingRecordInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jiakun on 17-5-1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/service-beans.xml"})
public class BookingRecordServiceTest {
    @Autowired
    private BookingRecordService bookingRecordService;

    @Test
    public void test() throws Exception{
        saveBookingResult();
        queryBookingResult();
    }
    @Test
    public void saveBookingResult() throws Exception {
        System.out.println(bookingRecordService.saveBookingResult("PEK","HKG","0J0D","amadues",1,"2017-04-25 16:02:04"));
        System.out.println(bookingRecordService.saveBookingResult("PEK","HKG","0J0D","amadues",1,"2017-04-25 16:06:08"));
        System.out.println(bookingRecordService.saveBookingResult("PEK","HKG","0J0D","amadues",1,"2017-04-25 16:08:08"));
        System.out.println(bookingRecordService.saveBookingResult("PEK","HKG","0J0D","amadues",1,"2017-04-25 16:12:08"));
        System.out.println(bookingRecordService.saveBookingResult("PEK","HKG","0J0D","amadues",2,"2017-04-25 16:22:09"));
        System.out.println(bookingRecordService.saveBookingResult  ("PEK","HKG","0J0D","amadues",2,"2017-04-25 16:02:03"));
        System.out.println(bookingRecordService.saveBookingResult("PEK","HKG","0J0D","sabre",2,"2017-04-25 16:24:08"));
    }
    @Test
    public void queryBookingResult() throws Exception{
        final List<BookingRecordInfo> bookingRecordInfos = bookingRecordService.queryBookingResult("2017-04-03 13:08:08", "2017-04-26 15:02:08");
        for (BookingRecordInfo bookingRecordInfo : bookingRecordInfos) {
            System.out.println(bookingRecordInfo);
        }
    }

    @Test
    public void deleteBookingResultByTime() throws Exception {
        System.out.println(bookingRecordService.deleteBookingResultByTime("2017-04-25 13:02:04"));
    }

}