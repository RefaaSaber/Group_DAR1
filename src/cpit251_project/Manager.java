package cpit251_project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Manager {
    private final Scanner inputScanner = new Scanner(System.in);

    public Transaction createTransaction() {
        try {
            System.out.print("----------------------------");
            System.out.print("Enter Transaction Name: ");
            String transactionName = inputScanner.nextLine();

            LocalDate startDate = getDateInput("Enter start date (YYYY-MM-DD): ");
            LocalDate endDate = getDateInput("Enter end date (YYYY-MM-DD): ");

            if (startDate.isAfter(endDate)) {
                System.out.println("Error: Start date must be before or equal to end date.");
                return null;
            }

            Transaction newTransaction = new Transaction(transactionName, startDate, endDate);

            while (true) {
                System.out.print("Assign employee (or type 'done' to finish): ");
                String employeeName = inputScanner.nextLine().trim();
                if (employeeName.equalsIgnoreCase("done")) break;

                LocalDate deadline = getDateInput("Enter deadline for employee (YYYY-MM-DD): ");

                if (deadline.isBefore(startDate) || deadline.isAfter(endDate)) {
                    System.out.println("Error: Deadline must be within the transaction period.");
                    continue;
                }

                newTransaction.assignEmployee(employeeName, deadline);
            }
            System.out.print("---------------------------------- ");
            System.out.println("Transaction Created Successfully!");
            System.out.println(newTransaction);
            return newTransaction;

        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            return null;
        }
    }

    private LocalDate getDateInput(String prompt) throws DateTimeParseException {
        System.out.print(prompt);
        return LocalDate.parse(inputScanner.nextLine().trim());
    }
}
