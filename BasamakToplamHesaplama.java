import java.util.Scanner;

public class BasamakToplamHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        int sayi = scanner.nextInt();

        // Sayının basamaklarının toplamını saklayacak değişken
        int toplam = 0;

        // Sayıyı her seferinde 10'a bölerek basamaklarına ulaşırız
        while (sayi != 0) {
            // Sayının son basamağını alırız
            int basamak = sayi % 10;

            // Toplam değişkenine basamağı ekleriz
            toplam += basamak;

            // Sayıdan son basamağı çıkarırız
            sayi /= 10;
        }

        System.out.println("Basamakların toplamı: " + toplam);

        scanner.close();
    }
}
