import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import java.io.IOException;
import java.util.Iterator;

/**
 * 抓取网页并获取某些元素内容
 * Created by xuzhu on 16-9-24.
 */
public class ProcessWebPagesServiceTest {
public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    @Test
    public void testprocessWebPages() throws IOException {
        GrabWebService grabWebService=new GrabWebService();
        ParseHtmlService parseHtmlService=new ParseHtmlService();
        String url="*****";
        String html = grabWebService.grabWeb(url);
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(html);
        if (jsonNode.has("list")){
            JsonNode list = jsonNode.get("list");
            Iterator<JsonNode> iterator = list.iterator();
            while (iterator.hasNext()){
                JsonNode next = iterator.next();
                if (next.has("back")&&next.has("go")){
                    JsonNode back = next.get("back");
                    JsonNode go = next.get("go");
                    String goArrDate = go.get("arrDate").textValue();
                    String backDepDate = back.get("depDate").textValue();
                    String goEndTime = go.get("etime").textValue();
                    String backBeginTime = back.get("btime").textValue();
                    DateTime goArrTime= DATE_TIME_FORMATTER.parseDateTime(goArrDate+" "+goEndTime);
                    DateTime backDepTime= DATE_TIME_FORMATTER.parseDateTime(backDepDate+" "+backBeginTime);
                    if (goArrTime.compareTo(backDepTime)>=0){
                        System.out.println(goArrDate+" "+goEndTime+" - "+backBeginTime );
                        System.out.println(next.get("code").toString());
//                        System.out.println(next.toString());
                    }
                }
            }
        }
    }

}