import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * html字符串解析成json
 * Created by xuzhu on 16-9-25.
 */
public class JsonParseService {
    private ObjectMapper objectMapper;
    public JsonParseService(){
        objectMapper=new ObjectMapper();
    }
    public void getValue(String jsonStr) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(jsonStr);
        jsonNode.get("");
    }
}
