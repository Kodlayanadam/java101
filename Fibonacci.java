import java.util.Scanner;

public class FibonacciSeries {
        static int Fibonacci(int index){

        int res;
        if (index < 0)
            return -1;
        else if(index < 2)
            return index;
        res = Fibonacci(index - 1) + Fibonacci(index - 2); // Collects the previous and two previous numbers of the parameter and sends it back to the function
        return  res;
    }

    public static void main(String[] args) {

        Scanner limInput = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int limit = limInput.nextInt();

        if (Fibonacci(limit) == -1){
            System.out.println("Geçersiz sayı!");
            return;
        }
        System.out.println("Fibonacci Serisi: ");
        for(int i = 1; i <= limit; i++)
            System.out.print(Fibonacci(i) +" ");
    }
}
