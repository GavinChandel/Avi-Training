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
        // JSON parser to parse JSON data
        JSONParser jparser = new JSONParser();

        // Reading JSON data from a file
        FileReader reader = new FileReader("C:\\Users\\chand\\IdeaProjects\\jsonParser\\src\\main\\java\\avisoft\\fileHandling\\student-data.json");
        Object obj = jparser.parse(reader);
        JSONArray studentArray = (JSONArray) obj; // Array to hold student data

        // Variables for calculating total sum and class average
        int totalSum = 0;
        double classAvg = 0;

        // HashMap to store student names and their average marks
        HashMap<String, Double> map = new HashMap<>();

        // Iterating through each student object in the JSON array
        for(Object studentObj:studentArray){
            int sum = 0; // Variable to calculate total marks of a student
            double avg = 0; // Variable to store average marks of a student
            JSONObject student = (JSONObject) studentObj;

            // Extracting student data from JSON object
            String name = (String) student.get("name");
            String gender = (String) student.get("gender");
            long physics = (Long)student.get("physics");
            long maths = (Long)student.get("maths");
            long english = (Long)student.get("english");

            // Calculating total marks and average marks for each student
            sum+=maths+physics+english;
            totalSum+=sum;
            avg = sum/3;

            // Storing student name and average marks in the HashMap
            map.put(name, avg);
        }

        // Calculating class average
        classAvg = totalSum/studentArray.size();

        // Creating a JSON array to store results of students with average marks > 60
        JSONArray resultArray = new JSONArray();
        for(Map.Entry<String, Double> entry:map.entrySet()){
            String name = entry.getKey();
            double avg = entry.getValue();

            // Checking if the average marks of a student is greater than 60
            if(avg>60){
                // Creating a JSON object for the student with average marks > 60
                JSONObject sObj = new JSONObject();
                sObj.put("Name: ", name);
                sObj.put("Average Marks: ", avg);

                // Adding the student object to the result array
                resultArray.add(sObj);
            }
        }

        // Writing the result array to a JSON file
        FileWriter fr = new FileWriter("C:\\Users\\chand\\IdeaProjects\\jsonParser\\src\\main\\java\\avisoft\\fileHandling\\result.json");
        fr.write(resultArray.toString());
        fr.close();
    }
}
