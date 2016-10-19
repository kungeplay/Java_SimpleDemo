import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 解析html
 * Created by xuzhu on 16-9-24.
 */
public class ParseHtmlService {
    public String parseHtml(String page){
        Document parse = Jsoup.parse(page);
        Element body = parse.body();
        return body.children().toString();
//        return body.toString();

    }
}
