package xuzhu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiakun on 17-2-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ConsumerServiceTest {
    /**
     * 队列消息消费者,同步阻塞接收消息
     */
    @Autowired
    @Qualifier("consumerService")
    private ConsumerService consumerService;

    /**
     * 消息监听器,从queue2中异步监听消息
     */
    @Autowired
    @Qualifier("jmsContainer")
    private MessageListenerContainer jmsContainer;

    @Autowired
    @Qualifier("topicJmsContainer")
    private MessageListenerContainer topicJmsContainer;

    /**
     * 同步阻塞接收消息
     */
    @Test
    public void testConsumer() {
        consumerService.receive();
    }
}