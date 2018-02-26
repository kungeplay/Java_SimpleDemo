package com.jiakun.fresh.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Author: liujiakun
 * @Date: Created in 下午10:07 2018/2/6
 * @Description:
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        //// Create the SessionFactory from hibernate.cfg.xml
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(){ // Close caches and connection pools
        getSessionFactory().close();
    }
}
