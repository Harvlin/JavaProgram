package Program2;
import java.util.*;
public class ideal_weight {
      public static void main(String[] imt) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your body weight (kg): ");
            double w = sc.nextDouble();
            System.out.print("Enter your body height (cm): ");
            double h = sc.nextDouble();

            double h2 = h / 100;
            double result = w / (h2 * h2);
            System.out.println(result);

            // I don't know how implements switch into this
            if (result < 18.5) {
                  System.out.println("Skinny");
            } else if ((result > 18.6) && (result < 25)) {
                  System.out.println("Normal");
            } else if ((result > 25) && (result < 30)) {
                  System.out.println("Obese");
            } else if ((result > 30) && (result < 35)) {
                  System.out.println("Obese phase 1");
            } else if ((result > 35) && (result < 40)) {
                  System.out.println("Obese phase 2");
            } else if (result >= 40) {
                  System.out.println("Obese phase 3");
            } else {
                  System.out.println("Invalid input");
            }
            sc.close();
      }
}