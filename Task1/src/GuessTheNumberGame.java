import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // Random number 1-100
            int attempts = 0;
            int maxAttempts = 7; // Limit attempts per round
            boolean guessedCorrectly = false;

            System.out.println("\n🎮 New Round! Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Congratulations! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1); // More points if guessed quickly
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();
            playAgain = choice.equals("yes");
        }

        System.out.println("\n🎯 Game Over! Your final score: " + totalScore);
        sc.close();
    }
}
