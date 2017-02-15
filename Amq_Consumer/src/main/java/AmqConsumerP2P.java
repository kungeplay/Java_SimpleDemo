import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * amq的消费端,：点对点(P2P)模式
 * Created by jiakun on 17-1-22.
 */
public class AmqConsumerP2P {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session = null;//会话，接受或者发送消息的线程
        Destination destination;//消息的目的地
        MessageConsumer messageConsumer;//消息的消费者

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            // 启动连接
            connection.start();
            // 创建session，Session是我们操作消息的接口。可以通过session创建生产者、消费者、消息等。Session提供了事务的功能。
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//注意如果session以开启事务方式,则接收消息后必须调用session.commit方法.
            // 创建一个连接Hello World!的消息队列
            destination = session.createQueue("Hello World!");
            // 创建消息消费者
            messageConsumer = session.createConsumer(destination);
            while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);//接收消息阻塞时间100秒
                if (textMessage != null) {
                    System.out.println("收到的消息:" + textMessage.getText());
                } else {
                    break;
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                }
            }
            try {
                connection.close();
            } catch (JMSException e) {
            }
        }


    }
}
