package WeeklyAssgs.FileAssigner.src.classroom;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;

    private List subscribersList =  new ArrayList();

    Course(String name){
        this.courseName = name;
    }


    //getters and setters
    public int getCourseId(){return 0;}
    public String getCourseName(){
        return courseName;
    }

    public List getSubscribersList(){
        return subscribersList;
    }

    public void addSubscriber(WeeklyAssgs.FileAssigner.src.classroom.User student){
        subscribersList.add(student);
    }
}