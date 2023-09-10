
import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {
    public static void main(String[] args) {

        Random randNum = new Random();
        int randomNum = randNum.nextInt(10);

        Scanner numInput = new Scanner(System.in);
        int rights = 0;
        int rightsLimit = 5;
        int[] wrongCount = new int[rightsLimit];
        boolean isWrong = false;
        boolean isWin = false;

        System.out.println("1 ile 100 arasında bir sayı giriniz:");
        while (rights < rightsLimit){
            System.out.print("Misafir: ");
            int num = numInput.nextInt();

            if(num < 0 || num > 100){
                System.out.println("1 ile 100 arasında bir sayı girmediniz. Sınırlara dikkat edin!");
                continue;
            }
            if(num == randomNum){
                System.out.println("Tebrikler! Gizli sayıyı buldunuz.: "+ randomNum);
                isWin = true;
                break;
            }else{
                isWrong = true;
                wrongCount[rights++] = num;
                System.out.println("Numarayı bilemezdin");
                if(num > randomNum){
                    System.out.println("\n" +
                            "Tahmininiz gizli sayıdan daha büyük");
                }else {
                    System.out.println("\n" +
                            "Tahmininiz gizli sayıdan daha küçük"); //
                }
                System.out.println("\n" +
                        "Tekrar deneyin.\n" +
                        "Kalan hakkınız: "+ (rightsLimit-rights));
            }
            System.out.println("---------------------------------------------------------");
        }
        if (!isWin){
            System.out.println("Kaybettiniz!");
        }
        if (isWrong) {
            System.out.print("Yanlış tahmin: ");

            for (int i : wrongCount) {
                if (i != 0)
                    System.out.print(i + " ");
            }
        }
    }
}
