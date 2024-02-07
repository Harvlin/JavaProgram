import java.util.*;
public class document1 {
      static class Siswa {
            int nis, no;
            String nama;
            int[] nilai;
            Siswa() {
                  nilai = new int[3];
            }
      }
      public static void main(String[] document1) {
            Scanner sc = new Scanner(System.in);
            final int jm = 100;
            Siswa[] data = new Siswa[jm];
            int i = 0;
            while(true) {
                  data[i] = new Siswa();
                  data[i].no = i+1;
                  System.out.print("No " + data[i].no + " ");
                  System.out.print("Nama: ");
                  data[i].nama = sc.nextLine();
                  if (data[i].nama.equals("0000")) {
                        break;
                  }
                  System.out.print("Nis: ");
                  data[i].nis = sc.nextInt();
                  sc.nextLine();
                  data[i].nilai = new int[3];
                  for (int x = 0; x < 3; x++) {
                        System.out.print("Nilai " + (x + 1) + ": ");
                        data[i].nilai[x] = sc.nextInt();
                        sc.nextLine();
                  }
                  System.out.println("\n");
                  i++;
            }
            sc.close();
            System.out.println("\n\n\n");
            for (int m = 0; m < i; m++) {
                  System.out.printf("%2d %-8s %3d", data[m].no, data[m].nama, data[m].nis);
                  for (int x = 0; x < 3; x++) {
                        System.out.printf("%3d", data[m].nilai[x]);
                  }
                  System.out.println("\n");
            }
      }
}