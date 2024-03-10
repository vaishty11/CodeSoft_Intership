import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int totalAttemps = 0;
        int wonRound = 0;
        boolean playAgain = true;

        while (playAgain) {

            int randomNumber = rand.nextInt(0, 100);
            int attempts = 0;
            boolean guessCorrectly = false;
            int guessNumber;

            while (!guessCorrectly && attempts < 5) {
                System.out.println("Enter the Guess Number between (1 to 100)");
                guessNumber = sc.nextInt();
                attempts++;

                if (guessNumber == randomNumber) {
                    System.out.println(" The Guess is Correct");
                    guessCorrectly = true;
                    wonRound++;
                    break;
                } else if (guessNumber < randomNumber) {
                    System.err.println("The Guess is Too Low");
                } else if (guessNumber > randomNumber) {
                    System.out.println("The Guess is Too High");
                }
            }

            totalAttemps += attempts;
            System.out.println("Score for this round: " + (5 - attempts) + "/5");
            System.out.println("Total Attempts: " + totalAttemps);
            System.out.println("Won Round" + wonRound);
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = sc.next().toLowerCase();
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");

            sc.close();

        }
    }
}