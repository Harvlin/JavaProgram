package CompetitiveMaterial.Spiral;

import java.util.Scanner;
public class spiral1 {
      public static void main(String[] rawSpiral) {
            Scanner sc = new Scanner(System.in);
            int n;
            /*do {
                  n = sc.nextInt();
                  if (n % 2 == 0) {
                        System.out.print("Isi ulang n: ");
                  }
            } while (n % 2 == 0);*/
            n = sc.nextInt();
            sc.close();
            int[][] A = new int[n][n];
            int x = n / 2;
            int y = n / 2;
            int z = 1;
            int k = 0;
            int dir = 0;

            for (int i = 1; i <= (n * n); i++) {
                  A[y][x] = i;
                  switch (dir) {
                        case 0:
                              y--;
                              break;
                        case 1:
                              x--;
                              break;
                        case 2:
                              y++;
                              break;
                        case 3:
                              x++;
                              break;
                  }

                  if (i % z == 0) {
                        dir++;
                        if (dir > 3) {
                              dir = 0;
                        }
                  }
                  k++;
                  if (k == 2 * z) {
                        k = 0;
                        z++;
                  }
            }

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n; j++) {
                        System.out.printf("%3d", A[i][j]);
                  }
                  System.out.println();
            }
      }
}
