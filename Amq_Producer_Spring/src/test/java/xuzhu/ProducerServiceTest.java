package xuzhu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by jiakun on 17-2-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProducerServiceTest {
    /**
     * 队列名queue1
     */
    @Autowired
    private Destination queueDestination;
    /**
     * 队列名queue2
     */
    @Autowired
    private Destination queueDestination2;

    /**
     * 队列消息生产者
     */
    @Autowired
    @Qualifier("producerService")
    private ProducerService producerService;

    @Autowired
    @Qualifier("topicProvider")
    private TopicProvider topicProvider;

    /**
     * 测试生产者向queue1发送消息
     */
    @Test
    public void testProduce() {
        String msg = "Hello World!";
        producerService.sendMessage(msg);
    }

    /**
     * 测试消息监听
     * 1. 生产者向队列queue2发送消息
     * 2.ConsumerMessageListener异步监听队列，消费消息
     */
    @Test
    public void testSend() {
        producerService.sendMessage(queueDestination2, "Hello amq!");
    }

    @Test
    public void testTopic() throws Exception{
        topicProvider.publish("是topic发布的消息");
    }


}