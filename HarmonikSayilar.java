import java.util.Scanner;

public class HarmonikSayilar{
    public static void main(String[] args) {

        int num;
        double sum = 0;


        Scanner numInput = new Scanner(System.in);
        System.out.println("Bir sayı giriniz: ");
        num = numInput.nextInt();


        for (int i = 1; i <= num; i++){
            sum += ((double) 1 / i);
        }
        System.out.println(sum);
    }
}

