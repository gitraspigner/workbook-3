package com.pluralsight.PayrollExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Displays information for employees based off of a .csv file.
 * Lines of the input file containing employee information are formatted as such:
 * id|name|hours-worked|pay-rate
 *
 * @author Ravi Spigner
 */
public class PayrollCalculator {
    private final static String filePathAndName = "DataFiles/employees.csv";

    public static void main(String[] args) {
        displayEmployees(readFile(filePathAndName));
    }

    public static Employee[] readFile (String filePathAndName) {
        int numberOfEmployees = 0;
        //find number of employees for array size
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathAndName));
            String line;
            //skip first line, it is just the format of the file
            bufferedReader.readLine();
            while(bufferedReader.readLine() != null) {
                numberOfEmployees++;
            }
            System.out.println("Number of Employees/Lines in file: " + numberOfEmployees);
            bufferedReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        //create array of size to hold employees
        Employee[] employees = new Employee[numberOfEmployees];
        //re-read the file, must create new filereader and bufferedreader
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathAndName));
            String line;
            //skip first line, it is just the format of the file
            bufferedReader.readLine();
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                String[] lineData = line.split("\\|");
                employees[i] = new Employee(Integer.parseInt(lineData[0]), lineData[1],
                        Double.parseDouble(lineData[2]), Double.parseDouble(lineData[3]));
                i++;
            }
            bufferedReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void displayEmployees(Employee[] employees) {
        for(int i = 0; i < employees.length; i++) {
            System.out.printf("Employee ID: %d, Employee Name: %s, Employee's Gross Pay: $%.2f.%n",
                    employees[i].getEmployeeID(), employees[i].getName(),
                    employees[i].getGrossPay());
        }
    }
}
