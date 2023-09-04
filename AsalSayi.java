import java.util.Scanner;

public class AsalSayi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        if (isAsal(sayi, 2)) {
            System.out.println(sayi + " bir asal sayıdır.");
        } else {
            System.out.println(sayi + " bir asal sayı değildir.");
        }

        scanner.close();
    }

    public static boolean isAsal(int sayi, int bolen) {
        if (sayi <= 1) {
            return false;
        }
        if (bolen == sayi) {
            return true;
        }
        if (sayi % bolen == 0) {
            return false;
        }

        return isAsal(sayi, bolen + 1);
    }
}
