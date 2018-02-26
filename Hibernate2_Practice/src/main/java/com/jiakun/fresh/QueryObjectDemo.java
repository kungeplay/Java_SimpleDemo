package com.jiakun.fresh;

import com.jiakun.fresh.persistence.HibernateUtils;
import com.jiakun.fresh.pojo.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;

/**
 * @Author: liujiakun
 * @Date: Created in 下午10:08 2018/2/6
 * @Description: 使用HQL的查询对象
 */
public class QueryObjectDemo {
    public static void main(String[] args) {
        SessionFactory factory= HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        //All the action with DB via Hibernate must be located in one transaction.Start Transaction.
        session.getTransaction().begin();
        // Create an HQL statement, query the object.Equivalent to the SQL statement:
        // Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
        String sql = "select e from " + Employee.class.getName() + " e " + " order by e.empName,e.empNo";
        // Create Query object.
        Query query=session.createQuery(sql);
        Iterator iterate = query.iterate();
        while (iterate.hasNext()){
            Employee next = (Employee)iterate.next();
            System.out.println("Emp: "+next.getEmpNo()+" : "+next.getEmpName());
        }
        // Commit data.
        session.getTransaction().commit();
    }
}
