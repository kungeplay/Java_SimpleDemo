package com.jiakun.fresh.service;

import com.jiakun.fresh.dao.ThoughPolicyCacheExpireDao;
import com.jiakun.fresh.pojo.BookingRecordInfo;
import com.jiakun.fresh.pojo.CacheExpireInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiakun on 17-5-2.
 */
@Service
public class ThoughPolicyCacheExpireService {
    @Resource
    private ThoughPolicyCacheExpireDao thoughPolicyCacheExpireDao;

    int insertOrUpdateCacheExpire(BookingRecordInfo bookingRecordInfo){
        return thoughPolicyCacheExpireDao.insertOrUpdateCacheExpire(bookingRecordInfo);
    }

    //缓存时效查询
    List<CacheExpireInfo> queryCacheExpire(String depCode, String arrCode, String pcc, String gdsType){
        return thoughPolicyCacheExpireDao.queryCacheExpire(depCode, arrCode, pcc, gdsType);
    }
}
