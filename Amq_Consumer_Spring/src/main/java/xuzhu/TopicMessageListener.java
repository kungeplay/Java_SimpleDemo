package xuzhu;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Topic消息接收器，和队列监听的代码一样。
 * Created by jiakun on 17-2-21.
 */
public class TopicMessageListener implements MessageListener {
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
                System.out.println("监听器TopicMessageListener接收到消息： \t" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
