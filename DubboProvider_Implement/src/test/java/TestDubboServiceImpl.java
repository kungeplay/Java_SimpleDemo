import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by xuzhu on 16-9-17.
 */
public class TestDubboServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDubboServiceImpl.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
        context.start();
        System.out.println("提供Dubbo服务者已注册成功");
        try {
            System.in.read();//让此程序一直跑，表示一直提供服务
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
