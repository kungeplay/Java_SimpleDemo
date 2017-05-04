package com.jiakun.fresh.dao;

import com.jiakun.fresh.pojo.BookingRecordInfo;
import com.jiakun.fresh.pojo.CacheExpireInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对采购分销搜索接口中的缓存时效表进行操作
 * Created by jiakun on 17-4-28.
 */
@Repository
public interface ThoughPolicyCacheExpireDao {
    /**
     * 存在则更新数据，不存在则插入数据。实现的关键是以表中的depcode,arrcode,pcc,gds_type作为unique key
     * @param bookingRecordInfo 插入或更新缓存时效表时使用的数据
     * @return
     */
    int insertOrUpdateCacheExpire(BookingRecordInfo bookingRecordInfo);

    //缓存时效查询
    List<CacheExpireInfo> queryCacheExpire(@Param("depcode") String depCode, @Param("arrcode") String arrCode, @Param("pcc") String pcc, @Param("gds_type") String gdsType);
}
