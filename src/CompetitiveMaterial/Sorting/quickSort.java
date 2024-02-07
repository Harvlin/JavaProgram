package CompetitiveMaterial.Sorting;
public class quickSort {
      static void swap(int arr[], int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
      }
      static int partition(int arr[], int low, int high) {
            int pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                  if (arr[j] <= pivot) {
                        i++;
                        swap(arr, i, j);
                  }
            }
            swap(arr, i + 1, high);
            return (i + 1);
      }
      static void QuickSort(int arr[], int low, int high) {
            if (low < high) {
                  int pivot = partition(arr, low, high);
                  QuickSort(arr, low, pivot - 1);
                  QuickSort(arr, pivot + 1, high);
            }
      }
      static void printArray(int arr[], int size) {
            for (int i = 0; i < size; i++) {
                  System.out.println(arr[i]);
            }
      }
      public static void main(String[] QuickSort) {
            int array[] = {64, 34, 25, 12, 22, 11, 90};
            System.out.println("Array sebelum diurutkan: ");
            for (int l : array) {
                  System.out.println(l);
            }

            QuickSort(array, 0, array.length - 1);
            
            System.out.println("\nArray setelah diurutkan: ");
            for(int l: array) {
                  System.out.println(l);
            }
      }
}