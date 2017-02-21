package xuzhu;

import javax.jms.Destination;

/**
 * Created by jiakun on 17-2-20.
 */
public interface ConsumerService {
    void receive();
    void receive(Destination destination);
}
