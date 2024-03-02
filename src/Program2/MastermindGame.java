/**
 * ! In this game, we must choose a color between ren(R), green(G), blue(B), yellow(Y), white(W), and orange(O).
 * ? After that the program will notified to us wich color is in the wrong position or wich color is not in the list.
 * * Player have only 10 tries, with 4 unknown color list.
 */
package Program2;
import java.util.*;
public class MastermindGame {
      static final String[] COLORS = {"R", "G", "B", "Y", "W", "O"};
      static final int TRIES = 10;
      static final int CODE_LENGTH = 4;
      
      static String[] generateCode() {
            String[] code = new String[CODE_LENGTH];
            Random random = new Random();
            for(int i = 0; i < CODE_LENGTH; i++) {
                  code[i] = COLORS[random.nextInt(COLORS.length)];
            }
            return code;
      }
      static String[] guessCode() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Guess: ");
            sc.close();
            return sc.nextLine().toUpperCase().split(" ", CODE_LENGTH);
      }
      static int countCorrectPositions(String[] guess, String[] code) {
            int count = 0;
            for (int i = 0; i < CODE_LENGTH; i++) {
                  if (guess[i].equals(code[i])) {
                        count++;
                  }
            }
            return count;
      }
      static void playGame(Scanner sc) {
            System.out.printf("You have %d tries to guess.\n", TRIES);
            System.out.println("The valid colors are: " + String.join(", ", COLORS) + "\n");
            String[] code = generateCode();
            for (int attemps = 1; attemps <= TRIES; attemps++) {
                  String[] guess = guessCode();
                  int correctPos = countCorrectPositions(guess, code);
                  if (correctPos == CODE_LENGTH) {
                        System.out.printf("You guessed the code in %d tries.\n", attemps);
                        return;
                  }
                  System.out.printf("Correct position: %d | Incorrect posistion: %d\n", correctPos, CODE_LENGTH - correctPos);
            }
            System.out.println("You ran out of tries. The code was: " + String.join(" ", code));;
      }
      public static void main(String[] MastermindGame) {
            Scanner sc = new Scanner(System.in);
            boolean playAgain = true;
            while(playAgain) {
                  playGame(sc);
                  System.out.print("Do you want to play again (Y/N): ");
                  String answer = sc.nextLine().trim().toUpperCase();
                  playAgain = answer.equals("Y");
            }
            sc.close();
            System.out.println("Program complete");
      }
}