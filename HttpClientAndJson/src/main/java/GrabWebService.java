import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xuzhu on 16-9-23.
 */
public class GrabWebService {

    CloseableHttpClient closeableHttpClient;

    public GrabWebService() {
        closeableHttpClient = HttpClients.createDefault();
    }

    /**
     * 根据url抓取网页
     *
     * @param url web地址
     * @return 网页内容
     */
    public String grabWeb(String url) throws IOException {
        url=convertUrl(url);
        HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
        HttpEntity httpEntity = closeableHttpResponse.getEntity();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
        StringBuilder content=new StringBuilder();
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            content.append(readLine);
        }
        bufferedReader.close();
        return content.toString();
    }

    private String convertUrl(String url) {
        url=url.replaceAll("\\|","%7c");
        return url;
    }

    public static void main(String[] args) throws IOException {
        GrabWebService grabWebService=new GrabWebService();
        System.out.println(grabWebService.grabWeb("http://www.baidu.com"));
    }
}
