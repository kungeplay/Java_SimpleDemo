package com.jiakun.fresh;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.jiakun.fresh.model.People;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiakun on 17-3-22.
 */
public class PeopleCache {
    private LoadingCache<String,People> cache;

    public PeopleCache() {
        cache= CacheBuilder.newBuilder()
                .recordStats()
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .maximumSize(20)
                .initialCapacity(10)
                // .removalListener()
                .build(new CacheLoader<String, People>() {
                    @Override
                    public People load(String s) throws Exception {
                        return new People();
                    }
                });
    }
}
