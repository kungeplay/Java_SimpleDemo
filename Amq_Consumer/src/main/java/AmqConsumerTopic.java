import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiakun on 17-1-23.
 */
public class AmqConsumerTopic {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static final String CLIENTID="5";

    public static void main(String[] args) {
        //连接工厂,JMS 用它创建连接
        ConnectionFactory factory;
        //连接实例,JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        //收发的线程实例,一个发送或接收消息的线程
        Session session=null;
        //消息发送目标地址
        Topic topic;
        //实例化连接工厂
        factory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);

        try {
            //获取连接实例
            connection = factory.createConnection();
            //启动连接
            connection.start();
            //获取操作连接
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建队列(返回一个消息目的地)
            topic = session.createTopic("FirstTop");
            //创建消息订阅者
            MessageConsumer messageConsumer = session.createConsumer(topic);

            //消息发布者添加监听器
            //接收和处理消息的方法有两种，分为同步和异步的，一般同步的方式我们是通过MessageConsumer.receive()方法来处理接收到的消息。
            //而异步的方法则是通过注册一个MessageListener的方法，使用MessageConsumer.setMessageListener()。
            messageConsumer.setMessageListener(new TopicListener("订阅者1"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        try {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.stop();
                connection.close();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
