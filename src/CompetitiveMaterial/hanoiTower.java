package CompetitiveMaterial;

import java.util.Scanner;

public class hanoiTower {
      static void hanoi(int n, char source, char destination, char auxiliary) {
            if (n == 1) {
                  System.out.printf("Pindahkan cakram 1 dari tiang %c ke tiang %c\n", source, destination);
                  return;
            }
            // Memindahkan n - 1 cakram dari tiang sumber ke tiang bantuan, menggunakan tujuan sebagai tiang bantuan
	      hanoi(n - 1, source, auxiliary, destination);
            System.out.printf("Pindahkan cakram %d dari tiang %c ke tiang %c\n", n, source, destination);
            // Memindahkan n - 1 cakram dari tiang bantuan ke tujuan, menggunakan sumber sebagai tiang bantuan
	      hanoi(n - 1, auxiliary, destination, source);
      }
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int numDiscs = sc.nextInt();
            hanoi(numDiscs, 'A', 'B', 'C');
            sc.close();
      }
}
