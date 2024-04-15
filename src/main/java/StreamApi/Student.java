package StreamApi;

import java.util.ArrayList;
import java.util.List;

final public class Student {

   final private   String name;
   final private   int studentId;
   final private  long percentage;

   final private List<String> friends;

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public long getPercentage() {
        return percentage;
    }

    public List<String> getFriends() {
        List<String> templates = new ArrayList<>();
        for(String value:friends){
            templates.add(value);
        }
        return templates;
    }

    public Student(String name, int studentId, long percentage, List<String> friends) {
        this.name = name;
        this.studentId = studentId;
        this.percentage = percentage;
//        this.friends = friends;

        List<String> templates = new ArrayList<>();
        for(String value:friends){
            templates.add(value);
        }
        this.friends=templates;
    }

    public void display(){
        System.out.println(this.name);
        System.out.println(this.studentId);
        System.out.println(this.percentage);
        System.out.println(this.friends);
    }
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", studentId=" + studentId +
//                ", percentage=" + percentage +
//                '}';
//    }
}
