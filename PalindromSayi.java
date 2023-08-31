import java.util.Scanner;

public class PalindromSayi {
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int sayi = scanner.nextInt();

       
        int tersSayi = tersiniBul(sayi);

     
        if (sayi == tersSayi) {
            System.out.println(sayi + " Bir palindrom sayıdır.");
        } else {
            System.out.println(sayi + " Bir palindrom sayı değildir.");
        }
    }

 
    public static int tersiniBul(int sayi) {
        int tersSayi = 0;
        while (sayi != 0) {
            int kalan = sayi % 10;
            tersSayi = tersSayi * 10 + kalan;
            sayi = sayi / 10;
        }
        return tersSayi;
    }
}
