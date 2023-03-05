import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        //declare class variables
        boolean restart = true;
        boolean runLoop;

        //declare scanner class
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the Craps Game. ");

        //do while loop to restart the game
        do {
            //declare loop variables
            int point = 0;
            String inputStore;

            //do while loop to begin the game when player enters 'start'
            do {
                System.out.print("Please type 'start' to begin the game: "); //output to user
                inputStore = input.nextLine(); //stores input
                //checks whether user input is equal to start
                if (inputStore.equalsIgnoreCase("start")) {
                    runLoop = false;
                } else {
                    System.out.println("Sorry, invalid input.");
                    runLoop = true;
                }
            } while (runLoop);

            //declare Random variable
            Random rnd = new Random();
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2; // Gaussian range from 2 to 12 as in rolling two dice

            //checks whether crapsRoll is 2, 3, 12 (loss), 7, 11 (win), or different value to store in point
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("You rolled a " + crapsRoll + ". This means you have crapped out (lost).");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("You rolled a " + crapsRoll + ". That's a natural, so you have won!");
            } else {
                point = crapsRoll;
                System.out.println("Your rolled a " + crapsRoll + ". This means you roll again!");
            }

            //checks if the point variable has a value
            if (point != 0) {
                //do while loop until roll is 7 or same value as point
                do{
                    //do while loop to run roll when user enters 'r'
                    do {
                        System.out.print("Please type 'r' to roll again: ");
                        inputStore = input.nextLine();
                        if (inputStore.equalsIgnoreCase("r")) {
                            runLoop = false;
                        } else {
                            System.out.println("Sorry, invalid input.");
                            runLoop = true;
                        }
                    } while (runLoop);

                    //devlare new random variable
                    rnd = new Random();
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2; // Gaussian range from 2 to 12 as in rolling two dice

                    //checks if crapsRoll is equal to point(win), 7 (loss), or another roll
                    if (crapsRoll == point) {
                        System.out.println("You rolled a " + crapsRoll + " again. You have won!");
                        runLoop = false;
                    } else if (crapsRoll == 7) {
                        System.out.println("You rolled a " + crapsRoll + ". You have lost.");
                        runLoop = false;
                    } else {
                        System.out.println("You rolled a " + crapsRoll + ". You roll again!");
                        runLoop = true;
                    }
                } while (runLoop);
            }

            //do while loop to ask user whether they want to play again
            do {
                System.out.print("Would you like to play again? Please enter Y/N: "); //output to user
                inputStore = input.nextLine();//user input

                //checks whether input is yes, no, or invalid
                if (inputStore.equalsIgnoreCase("y")) {
                    runLoop = false;
                    restart = true;
                } else if (inputStore.equalsIgnoreCase("N")) {
                    runLoop = false;
                    restart = false;
                } else {
                    System.out.println("Sorry, invalid input.");
                    runLoop = true;
                }
            } while (runLoop);
        } while(restart);
    }
}