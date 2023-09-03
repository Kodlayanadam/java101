import java.util.Scanner;

public class AdvancedCalculator {

    static void sum(int a, int b){
        int result = a + b;
        System.out.println("Toplama: "+ result);
    }
    static void minus(int a, int b){
        int result = a - b;
        System.out.println("Çıkarma: "+ result);
    }
    static void times(int a, int b){
        int result = a * b;
        System.out.println("Çarpma: "+ result);
    }
    static void division(int a, int b){
        int result = a / b;
        System.out.println("Bölme: "+ result);
    }
    static void power(int a, int b){
        int result = 1;
        for (int i = 1, k = 1; k <= b; k++, i *= a){
            result = i * a;
        }
        System.out.println(a+" ^ "+ b +" = " + result);
    }
    static void factorial(int a){
        int aFac = 1;
        while (a > 1){
            aFac *= a;
            a--;
        }
        System.out.println(a+"Faktöriyel: "+aFac);
    }
    static void modulo(int a, int b){
        int result;
        result = a % b;
        System.out.println(a+" % " +b+ " = "+result);
    }
    static void rectangle(int a, int b){
        int areaR, perimeterR;
        areaR = a * b;
        System.out.println("a. kenar: "+a+" | b. kenar: "+b+" Alan= "+ areaR);
        perimeterR = 2*(a + b);
        System.out.println("a. kenar: "+a+" | b. kenar: "+b+" Çevre= "+ perimeterR);
    }

    public static void main(String[] args) {

        Scanner numInput = new Scanner(System.in);
        int select;

        String menu = """ 
                1- Toplama İşlemi
                2- Çıkarma İşlemi
                3- Çarpma İşlemi
                4- Bölme İşlemi
                5- Üs Alma İşlemi
                6- Faktöriyel
                7- Mod Alma işlemi
                8- Dikdörtgenin Alan ve çevresini bulma işlemi
                9- Çıkış
                """;
        while(true) {
            System.out.println(menu);
            System.out.println("---------------------------------");
            System.out.print("İşlem seçiniz: ");
            select = numInput.nextInt();
            if (select == 9)
                break;
            System.out.print("İlk sayı: ");
            int a = numInput.nextInt();
            System.out.print("İkinci Sayı: ");
            int b = numInput.nextInt();
            switch (select) {
                case 1 -> sum(a, b);
                case 2 -> minus(a, b);
                case 3 -> times(a, b);
                case 4 -> {
                    if (b == 0)
                        System.out.println("Payda sıfır olamaz. Tekrar deneyin");
                    else
                        division(a, b);
                }
                case 5 -> power(a,b);
                case 6 -> {
                    if ( b != 0)
                        System.out.println("İkinci bir değer alınamıyor");
                    else
                        factorial(a);
                }
                case 7 -> modulo(a,b);
                case 8 -> rectangle(a,b);
            }
        }
        System.out.println("Program kapatıldı");
    }
}
