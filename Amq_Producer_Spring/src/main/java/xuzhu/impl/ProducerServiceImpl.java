package xuzhu.impl;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import xuzhu.ProducerService;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 使用spring jms 发送消息
 * Created by jiakun on 17-2-20.
 */
public class ProducerServiceImpl implements ProducerService {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(final String msg) {
        final String destination = jmsTemplate.getDefaultDestination().toString();
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
        System.out.println("向队列" + destination + "发送了消息------" + msg);
    }

    public void sendMessage(Destination destination, final String msg) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
