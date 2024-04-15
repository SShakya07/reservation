package StreamApi;

public interface demo {
    public int Sum(int a, int b);

    public static void main(String[] args){
          demo d = (x,y)->x+y;
        int sum = d.Sum(3, 6);
        System.out.println(sum);
    }
}
