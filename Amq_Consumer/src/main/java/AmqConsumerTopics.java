import com.google.common.collect.Lists;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 多主题发布,一个生产者/发布者：可以向多个目的地发送消息
 * 每个目的地（destination）可以有多个订阅者或消费者
 * 一个订阅者或消费者只能只能订阅一个主题,但一个主题可以由多个订阅者订阅
 * 启动时先启动消费者
 * Created by jiakun on 17-2-14.
 */
public class AmqConsumerTopics {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static List<String> TOPICSSSTRS = Lists.newArrayList("myTopic1", "myTopic2", "myTopic3", "myTopic4");

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory;
        //连接实例
        Connection connection = null;
        //收发的线程实例
        Session session = null;
        List<MessageConsumer> messageConsumers = Lists.newArrayList();
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            for (String topicssstr : TOPICSSSTRS) {
                //每个主题有两个订阅者
                Topic topic = session.createTopic(topicssstr);
                messageConsumers.add(session.createConsumer(topic));
                messageConsumers.add(session.createConsumer(topic));
            }
            for (int i = 0; i < messageConsumers.size(); i++) {
                //接收和处理消息的方法有两种，分为同步和异步的，一般同步的方式我们是通过MessageConsumer.receive()方法来处理接收到的消息。
                //而异步的方法则是通过注册一个MessageListener的方法，使用MessageConsumer.setMessageListener()。
                messageConsumers.get(i).setMessageListener(new MapMessageListener("订阅者" + i));
            }
            TimeUnit.SECONDS.sleep(1000);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            for (MessageConsumer messageConsumer : messageConsumers) {
                try {
                    messageConsumer.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static class MapMessageListener implements MessageListener {
        private String name;

        public MapMessageListener(String name) {
            this.name = name;
        }

        public void onMessage(Message message) {
            if (message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                try {
                    String messageName = mapMessage.getString("messageName");
                    int len = mapMessage.getInt("len");
                    System.out.println("订阅者:" + this.name + ",接收到消息: " + messageName + ",len:" + len);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
