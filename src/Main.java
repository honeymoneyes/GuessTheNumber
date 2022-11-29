import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new GuessTheNumber().Controller();
    }
}
class GuessTheNumber {
    int random;
    String choice;

    public GuessTheNumber() {
        random = new Random().nextInt(101);
    }

    public void checkTheNumber() {
        int userNumber = 0;
        int numberOfFail = 0;
        int numberOfAttempts = numberOfAttempts(random) + 2;
        while (userNumber != random || numberOfAttempts == numberOfFail) {
            System.out.println("Enter the number: ");
            userNumber = new Scanner(System.in).nextInt();
            if (userNumber == random) {
                System.out.println("You're winner!");
                break;
            } else {
                if (userNumber < random) {
                    System.out.println("Your number is less than the desired one");
                    System.out.println("You have: " + (numberOfAttempts-(++numberOfFail)) + " attempts left");
                } else if (userNumber > random) {
                    System.out.println("Your number is bigger than the one you made");
                    numberOfFail++;
                    System.out.println("You have: " + (numberOfAttempts-(++numberOfFail)) + " attempts left");
                }
            }
        }
    }
    public int numberOfAttempts(int number) {
        int count = 0;
        while (number != 1) {
            number /= 2;
            count++;
        }
        return count;
    }
    public void welcome() {
        System.out.println("Welcome to the \"Guess the Number\" game!\nDo you want to play?");
        playAgain();

    }
    public void playAgain() {
        boolean is_0 = true;
        while (is_0) {
            System.out.println("\nEnter the answer: ");
            choice = new Scanner(System.in).nextLine().toUpperCase();
            switch (choice) {
                case "YES" -> {
                    System.out.println("Let's get started!");
                    is_0 = false;
                }
                case "NO" -> {
                    System.out.println("See you another time, bye!");
                    System.exit(0);
                }
            }
        }
    }
    public void Controller() {
        welcome();
        checkTheNumber();
        System.out.println("Play Again?");
        playAgain();
    }
}
