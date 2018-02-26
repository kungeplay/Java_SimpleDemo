package com.jiakun.fresh;

import com.jiakun.fresh.persistence.HibernateUtil;
import com.jiakun.fresh.pojo.Stock;
import org.hibernate.classic.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Stock stock = new Stock();
        stock.setStockCode("4715");
        stock.setStockName("GENM");
        session.save(stock);
        session.getTransaction().commit();
    }
}
