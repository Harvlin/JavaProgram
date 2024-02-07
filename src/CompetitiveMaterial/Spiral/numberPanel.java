package CompetitiveMaterial.Spiral;

import java.util.Scanner;

public class numberPanel {
      static void printArray(int[][] A, int rows, int columns) {
            for (int x = 0; x < rows; x++) {
                  for (int y = 0; y < columns; y++) {
                        System.out.printf("%4d", A[x][y]);
                  }
            System.out.println();
            }
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[][] A = new int[100][100];
            int rows, columns;
            rows = sc.nextInt();
            columns = sc.nextInt();
            sc.close();
            int bi = 1;

            for (int i = 0; i < columns; i++) {
                  A[0][i] = bi;
                  bi++;
            }

            for (int x = 1; x < rows; x++) {
                  A[x][columns - 1] = bi;
                  bi++;
            }

            for (int y = columns - 2; y >= 0; y--) {
                  A[rows - 1][y] = bi;
                  bi++;
            }

            for (int x = rows - 2; x > 0; x--) {
                  A[x][0] = bi;
                  bi++;
            }

            printArray(A, rows, columns);
      }
}

