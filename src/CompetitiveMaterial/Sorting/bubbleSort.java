package CompetitiveMaterial.Sorting;
public class bubbleSort {
      static void sort(int a[]) {
            for (int i = 0; i < a.length; i++) {
                  for (int j = 0; j < a.length - 1; j++) {
                        if (a[j] > a[j + 1]) {
                              int sementara = a[j];
                              a[j] = a[j + 1];
                              a[j + 1] = sementara;
                        }
                  }
            }
      }
      static void print(int a[]) {
            for (int k = 0; k < a.length; k++) {
                  System.out.printf("a[%d] = %d\n", k, a[k]);
            }
      }
      public static void main(String[] sorting) {
            int a[] = {2, 4, 1, 3, 5, 7, 6, 8, 9, 10};
            sort(a);
            print(a);
      }
}