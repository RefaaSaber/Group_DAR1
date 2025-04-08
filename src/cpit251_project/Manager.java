package cpit251_project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Manager {

    private final Scanner inputScanner = new Scanner(System.in);

    public Transaction createTransaction() {
        printHeader("Create New Transaction");

        String transactionName = promptText("Enter Transaction Name: ");
        LocalDate startDate = promptDate("Enter start date (YYYY-MM-DD): ");
        LocalDate endDate = promptDate("Enter end date (YYYY-MM-DD): ");

        if (startDate.isAfter(endDate)) {
            System.out.println(" Error: Start date must be before or equal to end date.");
            return null;
        }

        Transaction transaction = new Transaction(transactionName, startDate, endDate);
        assignEmployees(transaction, startDate, endDate);

        printHeader("Transaction Created Successfully!");
        System.out.println(transaction);
        return transaction;
    }

    private String promptText(String prompt) {
        System.out.print(prompt);
        return inputScanner.nextLine().trim();
    }

    private LocalDate promptDate(String prompt) {
        while (true) {
            try {
                return LocalDate.parse(promptText(prompt));
            } catch (DateTimeParseException e) {
                System.out.println(" Error: Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }
   private void assignEmployees(Transaction transaction, LocalDate startDate, LocalDate endDate) {
        printHeader("Assign Employees");

        while (true) {
            String employeeName = promptText("Assign employee (or type 'done' to finish): ");
            if (employeeName.equalsIgnoreCase("done")) {
                break;
            }

            LocalDate deadline = promptDate("Enter deadline for employee (YYYY-MM-DD): ");
            if (deadline.isBefore(startDate) || deadline.isAfter(endDate)) {
                System.out.println("  Deadline must be within the transaction period.");
                continue;
            }

            transaction.assignEmployee(employeeName, deadline);
        }
    }

    private void printHeader(String title) {
        System.out.println("\n------------------------------");
        System.out.println(title);
        System.out.println("------------------------------");
    }
}
