package CompetitiveMaterial.Spiral;

import java.util.Scanner;

public class spiralDariLuarKeDalam {
      static void printSpiral(int rows, int columns, int[][] matrix) {
            for (int i = 0; i < rows; i++) {
                  for (int j = 0; j < columns; j++) {
                        System.out.printf("%3d ", matrix[i][j]);
                  }
                  System.out.println();   
            }
      }
      static void generateSpiral(int rows, int columns) {
            int[][] matrix = new int[rows][columns];
            int value = 1;
            int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
    
            while (top <= bottom && left <= right) {
                  for (int i = left; i <= right; i++) {
                        matrix[top][i] = value++;
                  }
                  top++;
    
                  for (int i = top; i <= bottom; i++) {
                        matrix[i][right] = value++;
                  }
                  right--;
    
                  if (top <= bottom) {
                        for (int i = right; i >= left; i--) {
                        matrix[bottom][i] = value++;
                        }
                        bottom--;
                  }
    
                  if (left <= right) {
                        for (int i = bottom; i >= top; i--) {
                              matrix[i][left] = value++;
                        }
                        left++;
                  }
            }
    
                  printSpiral(rows, columns, matrix);
      }
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int rows, columns;

            System.out.print("Enter the number of rows: ");
            rows = scanner.nextInt();

            System.out.print("Enter the number of columns: ");
            columns = scanner.nextInt();

            generateSpiral(rows, columns);

            scanner.close();
      }
}
