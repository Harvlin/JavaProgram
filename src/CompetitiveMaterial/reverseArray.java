package CompetitiveMaterial;
public class reverseArray{
      public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int size = arr.length;

            for (int i = 0; i < size / 2; i++) {
                  int temp = arr[i];
                  arr[i] = arr[size - i - 1];
                  arr[size - i - 1] = temp;
            }

            for (int i = 0; i < size; i++) {
                  System.out.println(arr[i]);
            }
      }
}