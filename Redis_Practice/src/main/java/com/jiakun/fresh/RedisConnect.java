package com.jiakun.fresh;

import redis.clients.jedis.Jedis;

/**
 * Created by jiakun on 17-4-24.
 */
public class RedisConnect {
    private static final String incrKey="incrKey";
    public static void main(String[] args) {
        //连接本地的Redis服务
        Jedis jedis=new Jedis("localhost");
        System.out.println("connect to server sucessfully");
        System.out.println("Server is running:"+jedis.ping());

        jedis.incr(incrKey);
        jedis.incr(incrKey);
        System.out.println(jedis.incr(incrKey));
        System.out.println(jedis.getSet(incrKey,"0"));
        jedis.close();
    }
}
