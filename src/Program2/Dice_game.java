package Program2;
import java.util.Scanner;
import java.util.Random;
public class Dice_game {
      private static int getMaxScore(int[] scores) {
            int maxScore = Integer.MIN_VALUE;
            for (int score : scores) {
                  if (score > maxScore) {
                        maxScore = score;
                  }
            }
            return maxScore;
      }
      public static void main(String[] args) {
            Random random = new Random();
            Scanner sc = new Scanner(System.in);

            int min_value = 1;
            int max_value = 6;
            int players;
            while(true) {
                  System.out.print("Enter the number of players (2 - 4): ");
                  if (sc.hasNextInt()) {
                        players = sc.nextInt();
                              if (players >= 2 && players <= 4) {
                                    break;
                              } else {
                                    System.out.println("Must be between 2 - 4");
                              }
                  } else {
                        System.out.println("Invalid");
                        sc.next();
                  }
            }
            int max_score = 50;
            int[] player_score = new int[players];

            while(getMaxScore(player_score) < max_score) {
                  for (int playerId = 0; playerId < players; playerId++) {
                        System.out.println("\nPlayer number " + (playerId + 1) + " turn has just started");
                        System.out.println("Your total score is: " + player_score[playerId]);
                        int current_score = 0;
                              while(true) {
                                    System.out.println("Would you like to roll (y) ? ");
                                    String should_roll = sc.next();
                                    if(!should_roll.toLowerCase().equals("y")) {
                                          break;
                                    }
                                    int value = random.nextInt(max_value - min_value + 1) + min_value;
                                          if(value == 1) {
                                                System.out.println("You rolled a 1, Turn done.");
                                                current_score = 0;
                                                break;
                                          } else {
                                                current_score += value;
                                                System.out.println("You rolled a: " + value);
                                          }
                                    System.out.println("Your score is: " + current_score);
                              }      
                  }
            }
            int maxScore = getMaxScore(player_score);
            int winningId = getWinningPlayerIndex(player_score, maxScore);
            System.out.println("Player number " + (winningId + 1) + " is the winner.");
            sc.close();
      }
      private static int getWinningPlayerIndex(int[] scores, int maxScore) {
            for (int i = 0; i < scores.length; i++) {
                  if (scores[i] == maxScore) {
                        return i;
                  }
            }
            return -1; 
      }
}