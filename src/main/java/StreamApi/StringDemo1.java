package StreamApi;

public class StringDemo1 {

//    public  void reverseArray(int [] arr){
//
//    }

    public static  void main(String[] args) {
//        String s= " \"abc  def \" ";
//        String s1 = s.replaceAll("\\s"," ");
//        String s2 = s.replaceAll("\\s+", "");
//
//        System.out.println(s1);//output abc def
//        System.out.println(s2);// "abc def"
// List<Integer> list = Arrays.asList(1,2,3,4,5);
//
// list.stream()

//        IntStream inStream = IntStream.of(1,2,3,4,5);
//        int[] intArray= inStream.toArray();
//
//        int[] reverse = new int[intArray.length];
//        for(int i=0; i<intArray.length; i++){
//            reverse[i]=intArray[intArray.length-1-i];
//        }
//
//        Stream<Integer>  reverseStream = Arrays.stream(reverse).boxed();
//        String result = reverseStream.map(Object::toString).collect(Collectors.joining(","));
//
//        System.out.println(result);



        int arr[]= {1,2,3,4,5};

        int n  = arr.length;
        int reverse[] = new int[n];

        for(int i =arr.length ; i>=0;i--){

            reverse[i]= arr[arr.length-i-1];
        }
        System.out.println(reverse);






    }
}
