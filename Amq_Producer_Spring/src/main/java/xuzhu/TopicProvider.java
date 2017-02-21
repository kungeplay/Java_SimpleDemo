package xuzhu;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 使用Spring jms发布topic消息
 * 在使用Spring JMS的时候，主题（Topic）和队列消息的主要差异体现在JmsTemplate中"pubSubDomain"是否设置为True。如果为True，则是Topic；如果是false或者默认，则是queue。
 * Created by jiakun on 17-2-20.
 */
public class TopicProvider {
    private JmsTemplate topicJmsTemplate;

    public void setTopicJmsTemplate(JmsTemplate topicJmsTemplate) {
        this.topicJmsTemplate = topicJmsTemplate;
    }

    /**
     * 向指定的topic发布消息
     * @param msg 要发送的消息
     */
    public void publish(final String msg) {
        topicJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                System.out.println("topic发布消息内容为:\t" + msg);
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 向指定的topic发布消息
     * @param topic topic
     * @param msg 要发送的消息
     */
    public void publish(final Destination topic, final String msg) {
        topicJmsTemplate.send(topic, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                System.out.println("topic name是" + topic.toString() + ",发布消息内容为:\t" + msg);
                return session.createTextMessage(msg);
            }
        });
    }
}
