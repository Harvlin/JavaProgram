package Program;
import java.util.Scanner;
import java.util.Random;

public class rps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String choices[] = {"rock", "paper", "scissor"};
        while (true) {
            int botIdx = random.nextInt(3);
            String botCh = choices[botIdx];
            System.out.print("Your's: ");
            String userCh = sc.nextLine().toLowerCase();

            if (userCh.equals("exit")) {
                break;
            }

            if (!(userCh.equals("rock") || userCh.equals("paper") || userCh.equals("scissor"))) {
                System.out.println("Invalid input. Please enter rock, paper, or scissor.");
                return;
            }

            System.out.println("Bot's: " + botCh);

            if (botCh.equals(userCh)) {
                System.out.println("Draw");
            } else if ((userCh.equals("rock") && botCh.equals("scissor")) || 
                       (userCh.equals("paper") && botCh.equals("rock")) || 
                       (userCh.equals("scissor") && botCh.equals("paper"))) {
                System.out.println("You Win!");
            } else {
                System.out.println("You Lose!");
            }
        }
        sc.close();
    }
}
