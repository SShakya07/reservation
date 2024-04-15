package StreamApi;

public class StringDemo {
    public static void main(String[] args) {
        String s1= "mike";
        String s2= "mike";
        String s3 = new String("mike");
        String s4= new String("mike");

        System.out.println(s1==s2);
        System.out.println(s1.equals(s3));
       System.out.println(s1==s3);
        System.out.println(s1.equals(s2));

        System.out.println(s2.equals(s4));

        System.out.println(s3==s4);
    }
}
