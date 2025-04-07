package cpit251_project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Manager {

    private final Scanner inputScanner = new Scanner(System.in);

    public Transaction createTransaction() {
        System.out.println("----------------------------");
        System.out.print("Enter Transaction Name: ");
        String transactionName = inputScanner.nextLine();

        LocalDate startDate = getDateInput("Enter start date (YYYY-MM-DD): ");
        LocalDate endDate = getDateInput("Enter end date (YYYY-MM-DD): ");

        if (startDate.isAfter(endDate)) {
            System.out.println("Error: Start date must be before or equal to end date.");
            return null;
        }

        Transaction newTransaction = new Transaction(transactionName, startDate, endDate);
        assignEmployees(newTransaction, startDate, endDate);

        System.out.print("---------------------------------- ");
        System.out.println("Transaction Created Successfully!");
        System.out.println(newTransaction);
        return newTransaction;
    }

    private LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return LocalDate.parse(inputScanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    private void assignEmployees(Transaction transaction, LocalDate startDate, LocalDate endDate) {
        while (true) {
            System.out.print("Assign employee (or type 'done' to finish): ");
            String employeeName = inputScanner.nextLine().trim();
            if (employeeName.equalsIgnoreCase("done")) {
                break;
            }

            LocalDate deadline;
            while (true) {
                try {
                    deadline = getDateInput("Enter deadline for employee (YYYY-MM-DD): ");
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
                }
            }

            if (deadline.isBefore(startDate) || deadline.isAfter(endDate)) {
                System.out.println("Error: Deadline must be within the transaction period.");
                continue;
            }

            transaction.assignEmployee(employeeName, deadline);
        }
    }
}
