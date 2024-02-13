package CompetitiveMaterial;

public class prime {
      public static void main(String[] args) {
            int n = 10;
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                  if (n % i == 0) {
                        isPrime = false;
                  }
            }
            if (isPrime) {
                  System.out.println("YA");
            } else {
                  System.out.println("Bukan");
            }
      }
}
