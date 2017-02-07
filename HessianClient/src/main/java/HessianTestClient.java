import com.caucho.hessian.client.HessianProxyFactory;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import model.Student;
import service.HessianService;

import java.net.MalformedURLException;
import java.util.Map;

/**
 *
 * Hessian客户端，验证Hessian的序列化及反序列化
 * Created by jiakun on 17-2-7.
 */
public class HessianTestClient {
    public static void main(String[] args) {
        String url = "http://localhost:8080/ServiceServlet";
        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
        hessianProxyFactory.setOverloadEnabled(true);//支持重载
        HessianService service;
        try {
            service = (HessianService) hessianProxyFactory.create(HessianService.class, url);
            Student student1 = service.constructStudent("王五", 23);
            System.out.println(student1);
            Map<String, Object> attachments = Maps.newHashMap();
            attachments.put("hobbies", new String[]{"篮球", "足球", "网球"});
            attachments.put("duties", Sets.newHashSet("打扫卫生", "擦黑板"));
            attachments.put("feature", Lists.newArrayList("高个","肤黑"));
            Student student2 = service.constructStudent("刘洋", 27, attachments);
            System.out.println(student2.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
