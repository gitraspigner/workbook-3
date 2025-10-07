package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Displays a bedtime story stored in a .txt file. Includes each line number of the story.
 *
 * @author Ravi Spigner
 */
public class BedtimeStories {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayStory(getStoryFilename());
        //this is an extra feature, not part of this assignment/exercise writeup
        boolean wantsAnotherStory = wantsAnotherStory();
        while (wantsAnotherStory) {
            displayStory(getStoryFilename());
            wantsAnotherStory = wantsAnotherStory();
        }
        System.out.println("Good Night, Sleep Tight!");
        scanner.close();
    }

    public static void displayStory(String filename) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            int lineNumber = 1;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getStoryFilename() {
        System.out.print("Enter the (file) name of the story (include .txt at the end): ");
        Scanner scanner = new Scanner(System.in);
        //line below handles underscores not being entered by the user
        return "DataFiles/" + scanner.nextLine().replaceAll(" ", "_");
    }

    //this is an extra feature, not part of this assignment/exercise writeup
    public static boolean wantsAnotherStory() {
        System.out.print("Do you want another bedtime story?(1-Yes, 2-No): ");
        Scanner scanner = new Scanner(System.in);
        //line below handles underscores not being entered by the user
        int input = scanner.nextInt();
        boolean wantsAnotherStory;
        if (input == 1) {
            wantsAnotherStory = true;
        } else if(input == 2) {
            wantsAnotherStory = false;
        } else {
            wantsAnotherStory = false;
        }
        return wantsAnotherStory;
    }
}
