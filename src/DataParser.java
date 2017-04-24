import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vajni on 2017.04.12..
 */
public class DataParser {

    Map<String, String> assignmentMap = new LinkedHashMap<String, String>();
    List<Map> mapList = new ArrayList<>();
    public void stringToMap(String textLine) {

        String text = textLine;
        for (String keyValue : text.split(" *& *")) {
            String[] pairs = keyValue.split(" *= *", 2);
            assignmentMap.put(pairs[0], pairs.length == 1 ? "" : pairs[1]);
        }
            mapList.add(assignmentMap);
    }


}
