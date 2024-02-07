package CompetitiveMaterial;
import java.util.Scanner;
import java.lang.Math;
public class primeNum {
      static boolean isPrime (int num) {
            if (num <= 1) {
                  return false;
            }
            for (int i = 3; i < Math.sqrt(num); i++) {
                  if (num %i == 0) {
                        return false;
                  }
            }
            return true;
      }
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = 0;
            System.out.print("Bilangan prima ke: "); short b = sc.nextShort();
            for (int i = 1; ; i++) {
                  if (isPrime(i)) {
                        n++;
                        System.out.printf("Bilangan prima ke %d adalah %d\n", n, i);
                        if (n == b) {
                              System.out.printf("Bilangan prima ke %d adalah %d", b, i);
                              break;
                        }
                  }
            }
            sc.close();
      }
}