import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;
        int totalScore = 0, roundsPlayed = 0;

        System.out.println("Welcome to the Number Game!");
        
        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            int score = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (roundsPlayed + 1) + ": I have selected a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    guessedCorrectly = true;
                    score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    System.out.println("Your score for this round is: " + score);
                }

                if (attempts == maxAttempts && !guessedCorrectly) {
                    System.out.println("Sorry! You've used all your attempts. The correct number was " + number + ".");
                }
            }

            roundsPlayed++;
            
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));
        System.out.println("\nGame Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Total Score: " + totalScore);

        scanner.close();
    }
}
