package com.jiakun.fresh.service;

import com.jiakun.fresh.pojo.BookingRecordInfo;
import com.jiakun.fresh.pojo.CacheExpireInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiakun on 17-5-2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/service-beans.xml"})
public class ThoughPolicyCacheExpireServiceTest {

    @Autowired
    private BookingRecordService bookingRecordService;
    @Resource
    private ThoughPolicyCacheExpireService thoughPolicyCacheExpireService;
    @Test
    public void insertOrUpdateCacheExpire() throws Exception {

        final List<BookingRecordInfo> bookingRecordInfos = bookingRecordService.queryBookingResult("2017-04-03 13:08:08", "2017-04-26 15:02:08");
        for (BookingRecordInfo bookingRecordInfo : bookingRecordInfos) {
            double successRate = (double) bookingRecordInfo.getSuccessNum() / bookingRecordInfo.getBookingNum();
            bookingRecordInfo.setSuccessRate(successRate);
            int updateDiff = successRate >= 0.8 ? 10 : -5;//
            bookingRecordInfo.setUpdateDiff(updateDiff);
            int insertExpire = successRate >= 0.8 ? 60 + 10 : 60 - 5;//插入使用的时效
            bookingRecordInfo.setInsertExpire(insertExpire);
            int lowLimit=10;//低值下限
            bookingRecordInfo.setLowLimit(lowLimit);
            System.out.println(thoughPolicyCacheExpireService.insertOrUpdateCacheExpire(bookingRecordInfo));
        }



    }

    @Test
    public void queryCacheExpire() throws Exception {
        final List<CacheExpireInfo> cacheExpireInfos = thoughPolicyCacheExpireService.queryCacheExpire("PEK", "HKG", "0J0D", "amadues");
        for (CacheExpireInfo cacheExpireInfo : cacheExpireInfos) {
            System.out.println(cacheExpireInfo);
        }
    }

}