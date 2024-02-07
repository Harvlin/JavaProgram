package CompetitiveMaterial.Spiral;
import java.util.Scanner;
public class spiralDaritengahNxN {
      static void printSpiral(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                  for (int j = 0; j < matrix.length; j++) {
                        System.out.printf("%3d", matrix[i][j]);
                  }
                  System.out.println();
            }
      }
      static void generateSpiral(short n) {
            int[][] matrix = new int[n][n];
            int value = n * n;
            int top = 0, bottom = n - 1, left = 0, right = n - 1;

            while (top <= bottom && left <= right) {
                  for (int i = bottom; i >= top; i--) {
                        matrix[i][right] = value--;
                  } right --;

                  for (int i = right; i >= left; i--) {
                        matrix[top][i] = value--;
                  } top++;

                  for (int i = top; i <= bottom; i++) {
                        matrix[i][left] = value--;
                  } left++;

                  for (int i = left; i <= right; i++) {
                        matrix[bottom][i] =value--;
                  } bottom--;
            }
            printSpiral(matrix);
      }
      public static void main(String[] spiralNxN) {
            Scanner sc = new Scanner(System.in);
            short n = sc.nextShort();
            generateSpiral(n);
            sc.close();
      }
}
