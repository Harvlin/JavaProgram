package CompetitiveMaterial;

public class prime {
      public static void main(String[] args) {
            int n = 10;
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                  if (n % 1 == 0) {
                        isPrime = false;
                  } else {
                        System.out.println("Ya");
                  }
            }
            if (isPrime) {
                  System.out.println("YA");
            } else {
                  System.out.println("Bukan");
            }
      }
}
