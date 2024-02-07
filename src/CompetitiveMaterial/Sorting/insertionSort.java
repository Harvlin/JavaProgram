package CompetitiveMaterial.Sorting;

public class insertionSort {
      static void Sort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                  int key = arr[i];
                  int j = i - 1;

                  while(j >= 0 && arr[j] > key) {
                        arr[j + 1] = arr[j];
                        j--;
                  }
                  arr[j + 1] = key;
            }
      }
      public static void main(String[]insertionsort) {
            int[] num = {9, 7, 5, 3, 2, 4, 10, 6, 8, 12, 20, 13, 11};
            Sort(num);
            for (int i = 0; i < num.length; i++) {
                  System.out.println(num[i]);
            }
      }
}
