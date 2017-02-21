package xuzhu;

import javax.jms.Destination;

/**
 * Created by jiakun on 17-2-20.
 */
public interface ProducerService {
    /**
     * 向默认队列发送消息
     *
     * @param msg
     */
    void sendMessage(final String msg);

    /**
     * 向指定队列发送消息
     *
     * @param destination 指定队列
     * @param msg 要发送的消息
     */
    void sendMessage(Destination destination, final String msg);
}
