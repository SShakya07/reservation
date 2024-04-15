package StreamApi;

import java.util.ArrayList;
import java.util.List;

public class ImmutableExample{
public static void main(String[] args) {
        System.out.println("immutable example");
List<String> list= new ArrayList<>();
list.add("Raman");
        Student student = new Student("Satyam",2,98,list);
//        System.out.println(student.name);

        student.display();

        System.out.println(student);

     //   student.name="Sani";
      //  System.out.println(student.name);
        student.display();
        System.out.println(student);
    }
}
