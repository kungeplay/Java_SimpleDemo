import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by jiakun on 17-1-24.
 */
public class TopicListener implements MessageListener {
    private String name;

    public TopicListener(String name) {
        this.name = name;
    }

    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            System.out.println(name + "接收到消息:" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
