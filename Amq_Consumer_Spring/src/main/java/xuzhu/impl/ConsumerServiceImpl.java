package xuzhu.impl;

import org.springframework.jms.core.JmsTemplate;
import xuzhu.ConsumerService;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * 消息消费者
 * Created by jiakun on 17-2-20.
 */
public class ConsumerServiceImpl implements ConsumerService {
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void receive(){
        Message message = jmsTemplate.receive();
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("从队列中收到消息:\t" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 接收消息 同步阻塞接收
     *
     * @param destination
     */
    public void receive(Destination destination) {
        Message message = jmsTemplate.receive(destination);
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("从队列中:" + destination.toString() + "收到消息:\t" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
