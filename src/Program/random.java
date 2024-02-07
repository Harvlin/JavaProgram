package Program;
import java.util.Random;
import java.util.Scanner;

public class random {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            if (userGuess == secretNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Correct number in " + attempts + " attempts.");
            } else if (userGuess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Too high");
            }
        }
        scanner.close();
    }
}
