package xuzhu.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 使用Spring Jms提供的消息监听模式：监听类代码
 * Created by jiakun on 17-2-20.
 */
public class QueueMessageListener implements MessageListener {
    //当收到消息时，自动调用此方法
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("监听器QueueMessageListener收到了文本消息:\t" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
