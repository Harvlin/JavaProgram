package CompetitiveMaterial.Sorting;
import java.util.Scanner;
public class binarySearch {
      static int BinarySearch(int array[], int left, int right, int target) {
            while (left <= right) {
                  int mid = left + (right - left) / 2;
                  if (array[mid] == target) {
                        return mid;
                  } 
                  if (array[mid] < target) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }
            return -1;
      }
      public static void main(String[] binarySearch) {
            Scanner sc = new Scanner(System.in);
            int numArr[] = {2, 4, 6, 8, 10, 12};
            short target = sc.nextShort();
            int result = BinarySearch(numArr, 0, numArr.length - 1, target);

                  if (result != -1) {
                        System.out.println(result);
                  } else {
                        System.out.println("Not found");
                  }
            sc.close();
      }
}