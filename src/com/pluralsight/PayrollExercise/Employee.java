package com.pluralsight.PayrollExercise;

/**
 * Represents an employee and their information including their employee ID, their name,
 * the number of hours they have worked, and the rate they are paid at.
 *
 * @author Ravi Spigner
 */
public class Employee {
    private int employeeID;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee() {
        this.employeeID = 0;
        this.name = "";
        this.hoursWorked = 0.0;
        this.payRate = 0.0;
    }

    public Employee(int employeeID, String name, double hoursWorked, double payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay() {
        return hoursWorked*payRate;
    }
}
