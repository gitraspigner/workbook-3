package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * A dummy search engine that logs the launch, search actions, and quitting of the user
 * with current date & time to a file called logs.txt.
 *
 * @author Ravi Spigner
 */
public class SearchEngineLogger {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("DataFiles/logs.txt"));
            String input = "";
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String now = LocalDateTime.now().format(format);
            bufferedWriter.write(now + " launch" + "\n");

            while (!input.equalsIgnoreCase("X")) {
                System.out.print("Enter a search term (X to exit): ");
                input = scanner.nextLine();
                now = LocalDateTime.now().format(format);
                bufferedWriter.write(now + " search : " + input + "\n");
            }
            bufferedWriter.write(now + " exit");
            scanner.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
