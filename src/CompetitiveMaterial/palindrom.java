package CompetitiveMaterial;
import java.util.Scanner;
public class palindrom {
      // for string input
      static boolean ispal(String text) {
            short kiri = 0; int kanan = text.length()  - 1;
            while (kiri < kanan) {
                  if (text.charAt(kiri) != text.charAt(kanan)) {
                        return false;
                  }
                  kiri++; kanan--;
            }
            return true;
      }
      // for int input
      static boolean isPal2(int num) {
            String numText = Integer.toString(num);
            short kiri = 0; int kanan = numText.length() - 1;
            while (kiri < kanan) {
                  if (numText.charAt(kiri) != numText.charAt(kanan)) {
                        return false;
                  }
                  kiri++; kanan--;
            }
            return true;
      }
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("text: ");String pal1 = sc.nextLine();
            System.out.print("num: ");int pal2 = sc.nextInt();
            if (ispal(pal1)) {
                  System.out.println("text Palindrom");
            }
            if (isPal2(pal2)) {
                  System.out.println("num Palindrom");
            }
            sc.close();
      }
}