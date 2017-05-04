package com.jiakun.fresh.service;

import com.jiakun.fresh.dao.BookingRecordDao;
import com.jiakun.fresh.pojo.BookingRecordInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiakun on 17-5-1.
 */
@Service
public class BookingRecordService {
    @Resource
    private BookingRecordDao bookingRecordDao;

    int saveBookingResult(String depCode, String arrCode, String pcc, String gds_type, int result, String recordTime) {
        return bookingRecordDao.saveBookingResult(depCode, arrCode, pcc, gds_type, result, recordTime);
    }


    List<BookingRecordInfo> queryBookingResult(String beginTime,String endTime){
        return bookingRecordDao.queryBookingResult(beginTime,endTime);
    }

    int deleteBookingResultByTime(String recordTime){
        return bookingRecordDao.deleteBookingResultByTime(recordTime);
    }

}
