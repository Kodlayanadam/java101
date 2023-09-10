import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        int satir = 3;
        int sutun = 3;
        int mayinSayisi = 3;
        char[][] oyunTahtasi = new char[satir][sutun];
        char[][] mayinlar = new char[satir][sutun];

        // Oyun tahtasını başlat
        baslangicTahtasiOlustur(oyunTahtasi, satir, sutun);
        mayinlariYerlestir(mayinlar, satir, sutun, mayinSayisi);

        boolean oyunDevamEdiyor = true;

        Scanner scanner = new Scanner(System.in);

        while (oyunDevamEdiyor) {
            tahtayiGoster(oyunTahtasi, satir, sutun);

            System.out.print("Satır seçin (0-2): ");
            int secilenSatir = scanner.nextInt();
            System.out.print("Sütun seçin (0-2): ");
            int secilenSutun = scanner.nextInt();

            if (mayinlar[secilenSatir][secilenSutun] == 'X') {
                System.out.println("Oyun bitti! Mayına bastınız.");
                oyunDevamEdiyor = false;
            } else {
                if (oyunTahtasi[secilenSatir][secilenSutun] == ' ') {
                    acilanHucreyiGoster(oyunTahtasi, mayinlar, secilenSatir, secilenSutun);
                    acilanHucreyiKontrolEt(oyunTahtasi, satir, sutun);
                    acilanHucreyiGoster(oyunTahtasi, mayinlar, secilenSatir, secilenSutun);
                    acilanHucreyiKontrolEt(oyunTahtasi, satir, sutun);
                    acilanHucreyiGoster(oyunTahtasi, mayinlar, secilenSatir, secilenSutun);
                    acilanHucreyiKontrolEt(oyunTahtasi, satir, sutun);
                    acilanHucreyiGoster(oyunTahtasi, mayinlar, secilenSatir, secilenSutun);
                    acilanHucreyiKontrolEt(oyunTahtasi, satir, sutun);
                    acilanHucreyiGoster(oyunTahtasi, mayinlar, secilenSatir, secilenSutun);
                    acilanHucreyiKontrolEt(oyunTahtasi, satir, sutun);
                } else {
                    System.out.println("Bu hücre zaten açıldı, lütfen başka bir hücre seçin.");
                }

                acilanHucreyiKontrolEt(oyunTahtasi, satir, sutun);

                if (acilanHucreyiKontrolEt(oyunTahtasi, satir, sutun)) {
                    System.out.println("Tebrikler, oyunu kazandınız!");
                    oyunDevamEdiyor = false;
                }
            }
        }

        scanner.close();
    }

    // Oyun tahtasını başlangıçta boş hale getirir
    public static void baslangicTahtasiOlustur(char[][] tahta, int satir, int sutun) {
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                tahta[i][j] = ' ';
            }
        }
    }

    // Mayınları rastgele yerleştirir
    public static void mayinlariYerlestir(char[][] mayinlar, int satir, int sutun, int mayinSayisi) {
        Random rand = new Random();
        for (int i = 0; i < mayinSayisi; i++) {
            int randSatir = rand.nextInt(satir);
            int randSutun = rand.nextInt(sutun);

            if (mayinlar[randSatir][randSutun] == 'X') {
                i--; // Eğer aynı hücreye tekrar mayın yerleştirilmek istenirse, tekrar deneyin
            } else {
                mayinlar[randSatir][randSutun] = 'X';
            }
        }
    }

    // Tahtayı ekrana basar
    public static void tahtayiGoster(char[][] tahta, int satir, int sutun) {
        System.out.println("Mayın Tarlası Oyunu");
        System.out.println("  0 1 2");
        for (int i = 0; i < satir; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < sutun; j++) {
                System.out.print(tahta[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Belirtilen hücreyi açar
    public static void acilanHucreyiGoster(char[][] tahta, char[][] mayinlar, int satir, int sutun) {
        if (satir >= 0 && satir < tahta.length && sutun >= 0 && sutun < tahta[0].length) {
            if (mayinlar[satir][sutun] == 'X') {
                tahta[satir][sutun] = 'X';
            } else {
                int mayinSayisi = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int yeniSatir = satir + i;
                        int yeniSutun = sutun + j;
                        if (yeniSatir >= 0 && yeniSatir < tahta.length && yeniSutun >= 0 && yeniSutun < tahta[0].length) {
                            if (mayinlar[yeniSatir][yeniSutun] == 'X') {
                                mayinSayisi++;
                            }
                        }
                    }
                }
                tahta[satir][sutun] = (char) (mayinSayisi + '0');
            }
        }
    }

    // Oyunun kazanılıp kazanılmadığını kontrol eder
    public static boolean acilanHucreyiKontrolEt(char[][] tahta, int satir, int sutun) {
        int acilanHucreSayisi = 0;
        int toplamHucreSayisi = satir * sutun;

        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                if (tahta[i][j] != ' ' && tahta[i][j] != 'X') {
                    acilanHucreSayisi++;
                }
            }
        }

        return acilanHucreSayisi == (toplamHucreSayisi - 3); // 3 mayın varsa oyun kazanılır
    }
}
