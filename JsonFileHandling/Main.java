package avisoft.fileHandling;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\chand\\IdeaProjects\\jsonParser\\src\\main\\java\\avisoft\\fileHandling\\student-data.json");
        Object obj = jparser.parse(reader);
        JSONArray studentArray = (JSONArray) obj;
        int totalSum = 0;
        double classAvg = 0;
        HashMap<String, Double> map = new HashMap<>();

        for(Object studentObj:studentArray){
            int sum = 0;
            double avg = 0;
            JSONObject student = (JSONObject) studentObj;

            String name = (String) student.get("name");
            String gender = (String) student.get("gender");
            long physics = (Long)student.get("physics");
            long maths = (Long)student.get("maths");
            long english = (Long)student.get("english");
            sum+=maths+physics+english;
            totalSum+=sum;
            avg = sum/3;
            map.put(name, avg);
        }
        classAvg = totalSum/studentArray.size();

        JSONArray resultArray = new JSONArray();
        for(Map.Entry<String, Double> entry:map.entrySet()){
            String name = entry.getKey();
            double avg = entry.getValue();

            if(avg>60){
                JSONObject sObj = new JSONObject();
                sObj.put("Name: ", name);
                sObj.put("Average Marks: ", avg);

                resultArray.add(sObj);
            }
        }
        FileWriter fr = new FileWriter("C:\\Users\\chand\\IdeaProjects\\jsonParser\\src\\main\\java\\avisoft\\fileHandling\\result.json");
        fr.write(resultArray.toString());
        fr.close();

    }
}