package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollReader {

    public static void main(String[] args) {

        String filePath = "employees.csv";  // Make sure this file is in your project folder

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            System.out.println("------ Payroll Report ------\n");

            while ((line = br.readLine()) != null) {

                // Split the line by the pipe character "|"
                String[] parts = line.split("\\|");

                // Parse data
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                // Create Employee object
                Employee emp = new Employee(id, name, hoursWorked, payRate);

                // Display payroll info
                System.out.println("Employee ID: " + emp.getEmployeeId());
                System.out.println("Name: " + emp.getName());
                System.out.println("Hours Worked: " + emp.getHoursWorked());
                System.out.println("Pay Rate: $" + emp.getPayRate());
                System.out.printf("Gross Pay: $%.2f%n", emp.getGrossPay());
                System.out.println("------------------------------\n");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}