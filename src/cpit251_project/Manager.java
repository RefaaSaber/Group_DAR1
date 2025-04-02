package cpit251_project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Manager {
    public Transaction createTransaction() {
        Scanner inputscanner = new Scanner(System.in);
        try {
            System.out.print("Enter Transaction Name: ");
            String transactionName = inputscanner.nextLine();

            System.out.print("Enter start date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(inputscanner.nextLine());

            System.out.print("Enter end date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(inputscanner.nextLine());

            if (startDate.isAfter(endDate)) {
                System.out.println("Error: Start date must be before or equal to end date.");
                return null;
            }

            Transaction newTransaction = new Transaction(transactionName, startDate, endDate);

            while (true) {
                System.out.print("Assign employee (or type 'done' to finish): ");
                String employeeName = inputscanner.nextLine().trim();
                if (employeeName.equalsIgnoreCase("done")) break;

                System.out.print("Enter deadline for employee (YYYY-MM-DD): ");
                LocalDate deadline = LocalDate.parse(inputscanner.nextLine());

                if (deadline.isBefore(startDate) || deadline.isAfter(endDate)) {
                    System.out.println("Error: Deadline must be within the transaction period.");
                    continue;
                }

                newTransaction.assignEmployee(employeeName, deadline);
            }

            System.out.println("Transaction Created Successfully!");
            System.out.println(newTransaction);
            return newTransaction;

        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            return null;
        }
    }
}