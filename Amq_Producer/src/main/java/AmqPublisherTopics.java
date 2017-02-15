import com.google.common.collect.Lists;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 多主题发布,一个生产者/发布者：可以向多个目的地发送消息
 * 每个目的地（destination）可以有多个订阅者或消费者
 * 一个订阅者或消费者只能只能订阅一个主题
 * * 启动时先启动消费者
 * Created by jiakun on 17-2-14.
 */
public class AmqPublisherTopics {
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

        MessageProducer producer = null;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(null);

            List<Topic> topics = Lists.newArrayListWithExpectedSize(TOPICSSSTRS.size());
            for (String topic : TOPICSSSTRS) {
                topics.add(session.createTopic(topic));
            }

            for (int i = 0; i < topics.size(); i++) {
                Message message = createMessage("消息" + i, i, session);
                sendMessage(producer, topics.get(i), message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (producer != null) {
                try {
                    producer.close();
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

    private static void sendMessage(MessageProducer producer, Topic topic, Message message) throws JMSException {
        producer.send(topic, message);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static Message createMessage(String name, int len, Session session) throws JMSException {
        MapMessage message = session.createMapMessage();
        message.setString("messageName", name);
        message.setInt("len", len);
        return message;
    }
}
