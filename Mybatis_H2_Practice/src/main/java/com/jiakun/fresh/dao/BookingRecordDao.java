package com.jiakun.fresh.dao;


import com.jiakun.fresh.pojo.BookingRecordInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 统计booking结果，存入数据库临时表中
 * Created by jiakun on 17-4-25.
 */
@Repository
public interface BookingRecordDao {
    /**
     * 记录booking信息
     * @param depCode 出发城市三字码
     * @param arrCode 到达城市三字码
     * @param pcc pcc
     * @param gds_type gds类型：amadues,sabre等
     * @param result booing结果：1表示成功，2表示失败
     * @param recordTime booking时间戳
     * @return
     */
    int saveBookingResult(@Param("depcode") String depCode, @Param("arrcode") String arrCode, @Param("pcc") String pcc,
                          @Param("gds_type") String gds_type, @Param("booking_result") int result, @Param("record_time") String recordTime);

    /**
     * 删除指定时间之前的Booking记录
     * @param recordTime 指定的时间
     * @return
     */
    int deleteBookingResultByTime(@Param("record_time")String recordTime);

    /**
     * 统计指定时间范围内的booking信息
     * @param beginTime 指定开始时间段
     * @param endTime 指定结束时间段
     * @return
     */
    List<BookingRecordInfo> queryBookingResult(@Param("begin_time")String beginTime, @Param("end_time")String endTime);
}

