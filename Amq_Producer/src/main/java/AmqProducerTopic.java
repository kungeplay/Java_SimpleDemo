import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiakun on 17-1-23.
 */
public class AmqProducerTopic {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 20;

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory;
        //连接实例
        Connection connection = null;
        //收发的线程实例
        Session session;
        //消息发送目标地址
        Destination destination;
        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        try {
            //获取连接实例
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建接收或发送的线程实例(创建session的时候定义是否要启用事务，且事务类型是AUTO_ACKNOWLEDGE也就是消费者成功在Listen中获得消息返回时,会话自动确定用户收到消息)
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //创建队列(返回一个消息目的地)
            destination = session.createTopic("FirstTop");
            //创建消息发布者
            MessageProducer messageProducer = session.createProducer(destination);
            //设置不持久化，此处学习，实际根据项目决定,默认PERSISTENT
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(session,messageProducer);
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {
        for (int i = 0; i < SENDNUM; i++) {
            //创建一条文本消息
            TextMessage message = session.createTextMessage("ActiveMQ 发布者订阅模型发送消息" + i);
            System.out.println("发送消息：amq发送消息" + i);
            //通过消息生产者发出消息
            messageProducer.send(message);
            session.commit();//注意如果session是以开启事务的方式创建必须session.commit()才能提交消息到服务器队列，session.close()服务器将收不到消息
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
