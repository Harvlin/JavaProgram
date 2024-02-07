package CompetitiveMaterial;
import java.util.*;
public class pembilangBil {
      static String[] satuan = {"", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan"};
      static String[] belasan = {"sepuluh", "sebelas", "dua belas", "tiga belas", "empat belas", "lima belas", "enam belas", "tujuh belas", "delapan belas", "sembilan belas"};
      static String[] puluhan = {"", "", "dua puluh", "tiga puluh", "empat puluh", "lima puluh", "enam puluh", "tujuh puluh", "delapan puluh", "sembilan puluh"};
      static String[] ribuan = {"", "ribu", "juta", "miliar"};

      static void terbilang(int n) {
            if (n == 0) {
                  System.out.println("Nol");
                  return;
            }

            int idx_ribuan = 0;

            while (n > 0) {
                  int ratusan = n % 1000;
                  if (ratusan > 0) {
                        System.out.print(satuan[ratusan / 100] + ((ratusan >= 100) ? " ratus " : ""));
                        if (ratusan % 100 > 0) {
                              if (ratusan % 100 < 10) {
                                    System.out.print(satuan[ratusan % 100] + " ");
                              } else if (ratusan % 100 < 20) {
                                    System.out.print(belasan[ratusan % 10] + " ");
                              } else {
                                    System.out.println(puluhan[(ratusan % 100) / 10] + " " + satuan[ratusan % 10] + " ");
                              }
                        }
                        System.out.println(ribuan[idx_ribuan] + " ");
                  }
                  n /= 1000;
                  idx_ribuan++;
            }
      }
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int bilangan = sc.nextInt();

            if (bilangan >= 1 && bilangan <= 2000000000) {
                  terbilang(bilangan);
            } else {
                  System.out.println("1 -> 2000000000");
            }
      }
}