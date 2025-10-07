package com.pluralsight;

import java.util.Scanner;

/**
 * Displays a quote to the user either at random or based off of a number that the user enters
 * that aligns with the number of quotes available.
 *
 * @author Ravi Spigner
 */
public class FamousQuotes {

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        String[] quotes = populateArray();
        Scanner scanner = new Scanner(System.in);
        displayWelcome();
        int selection;
        boolean finished = false;
        while (!finished) {
            selection = promptAndGetQuoteIndex(scanner);
            System.out.println("Displaying a quote for you...");
            if (selection == 0) {
                displayRandomQuote(quotes); //display random quote
            } else {
                try {
                    displayQuote(quotes, selection-1); //(try to) display quote at index
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("ERROR: Your number was not between 1 and " +
                            quotes.length +".");
                }
            }
            //ask user if they want another quote
            System.out.print("Would you like another quote? (1-Yes, 2-No): ");
            selection = scanner.nextInt();
            scanner.nextLine();
            if (selection == 1) {
                continue; //if yes, execute again
            } else if (selection == 2) {
                finished = true; //if no, then set finished to true, done executing
                //break; //could use this if doing while(true)
            } else {
                System.out.println("INVALID INPUT: Selection must be 1 (Yes) or 2 (No).");
                System.out.println("Executing program again...");
                continue; //if invalid input, notify user, execute again
            }
        }
        displayGoodbye();
    }

    public static void displayWelcome() {
        System.out.println("-Welcome To Famous Quotes-");
    }

    public static void displayGoodbye() {
        System.out.println("-Thank You For Using Famous Quotes-");
        System.out.println("Goodbye!");
    }

    public static String[] populateArray() {
        String[] quotes = new String[10];
        quotes[0] = "You better be careful when you talk about shedding blood in this community," +
                " it might just spill over on you. -Jimmy Witherspoon";
        quotes[1] = "I have a dream! -Dr. Martin Luther King Jr.";
        quotes[2] = "The world is uncivilized... and these are our words. -Stokely Carmichael";
        quotes[3] = "The only thing to fear is fear itself. -Franklin D. Roosevelt";
        quotes[4] = "I never really was on your side. -The Spy";
        quotes[5] = "You ain't got no pancake mix! -Anonymous";
        quotes[6] = "...or it'll get mixed in with the others and become just a coin, which it" +
                " is. -Javier Bardem";
        quotes[7] = "Yeah! -Travis Scott";
        quotes[8] = "I was never on your side either! -The Sniper";
        quotes[9] = "Wareehum quwtak! -Ana Amari";
        return quotes;
    }

    public static int promptAndGetQuoteIndex(Scanner scanner) {
        System.out.println("To display a random quote, please enter 0.");
        System.out.print("Otherwise to display a specific quote, please enter a number between " +
                "1 and 10: ");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static void displayQuote(String[] quotes, int index) {
        System.out.println("\"" + quotes[index] + "\"");

    }

    public static void displayRandomQuote(String[] quotes){
        int quoteIndex = (int) (Math.random()*quotes.length);
        displayQuote(quotes, quoteIndex);
    }
}
