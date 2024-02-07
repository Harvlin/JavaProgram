package CompetitiveMaterial;
import java.util.Scanner;
class Tanggal {
      int hari, bulan, tahun;

      public Tanggal (String tanggalString) {
            String[] tanggalArr = tanggalString.split("/");
            this.hari = Integer.parseInt(tanggalArr[0]);
            this.bulan = Integer.parseInt(tanggalArr[1]);
            this.tahun = Integer.parseInt(tanggalArr[2]);
      }

      // Menghitung selisih hari antara dua tanggal
      public static int hitungSelisihHari(Tanggal t1, Tanggal t2) {
            int selisihHari = 0;

            // Menghitung selisih tahun
            selisihHari += (t2.tahun - t1.tahun) * 365;
            // Menghitung selisih bulan
            selisihHari += (t2.bulan - t1.bulan) * 30;
            // Menghitung selisih hari
            selisihHari += t2.hari - t1.hari;

            return selisihHari;
      }
}
public class selisihTanggal {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); // Jumlah tanggal
            sc.nextLine();

            String tanggalString1 = sc.nextLine(); // Tanggal pertama
            Tanggal tanggal1 = new Tanggal(tanggalString1);

            int selisihHari = 0;

            // Membaca tanggal berikutnya dan selisih hari
            for (int i = 1; i < n; i++) {
                  String tannggalString2 = sc.nextLine();
                  Tanggal tanggal2 = new Tanggal(tannggalString2);

                  int selisih = Tanggal.hitungSelisihHari(tanggal1, tanggal2);
                  selisihHari += selisih;

                  tanggal1 = tanggal2;
            }
            sc.close();
            System.out.println(selisihHari);
      }
}