package cpit251_project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Manager {

    private final Scanner inputScanner = new Scanner(System.in);

    public Transaction createTransactionOnly() {
        printHeader("Create New Transaction");

        String transactionName = promptText("Enter Transaction Name: ");
        LocalDate startDate = promptDate("Enter start date (YYYY-MM-DD): ");
        LocalDate endDate = promptDate("Enter end date (YYYY-MM-DD): ");

        if (startDate.isAfter(endDate)) {
            System.out.println(" Error: Start date must be before or equal to end date.");
            return null;
        }

        String content = promptText("Enter Transaction Content/Description: ");

        Transaction transaction = new Transaction(transactionName, startDate, endDate);
        transaction.setContent(content);

        assignEmployeesToNewTransaction(transaction, startDate, endDate);

        printHeader("Transaction Created Successfully!");
        System.out.println(transaction);
        return transaction;
    }

    private void assignEmployeesToNewTransaction(Transaction transaction, LocalDate startDate, LocalDate endDate) {
        printHeader("Assign Employees to Transaction");

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

        System.out.println("Employees assigned successfully.");
    }

    public void editTransaction(Transaction transaction) {
        printHeader("Edit Transaction");

        while (true) {
            System.out.println("Editing Transaction: " + transaction.getTransactionName());
            System.out.println("Select which details to edit:");
            System.out.println("1. Edit Transaction Name");
            System.out.println("2. Edit Start Date");
            System.out.println("3. Edit End Date");
            System.out.println("4. Edit Content");
            System.out.println("5. Edit Assigned Employees");
            System.out.println("6. Done (Save and Exit)");

            System.out.print("Select option (1-6): ");
            String editOption = inputScanner.nextLine().trim();

            switch (editOption) {
                case "1":
                    String newName = promptText("Enter new transaction name: ");
                    transaction.setTransactionName(newName);
                    break;
                case "2":
                    LocalDate newStartDate = promptDate("Enter new start date (YYYY-MM-DD): ");
                    transaction.setStartDate(newStartDate);
                    break;
                case "3":
                    LocalDate newEndDate = promptDate("Enter new end date (YYYY-MM-DD): ");
                    transaction.setEndDate(newEndDate);
                    break;
                case "4":
                    String newContent = promptText("Enter new content/description: ");
                    transaction.setContent(newContent);
                    break;
                case "5":

                    transaction.getAssignedEmployees().clear();
                    assignEmployeesToNewTransaction(transaction, transaction.getStartDate(), transaction.getEndDate());
                    break;
                case "6":

                    System.out.println("Transaction editing complete!");
                    return;
                default:
                    System.out.println("Invalid option, no changes made.");
                    break;
            }
        }
    }

    protected String promptText(String prompt) {
        System.out.print(prompt);
        return inputScanner.nextLine().trim();
    }

    protected LocalDate promptDate(String prompt) {
        while (true) {
            try {
                String input = promptText(prompt);
                if (input.isEmpty()) {
                    return null;
                }
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println(" Error: Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    private void printHeader(String title) {
        System.out.println("\n------------------------------");
        System.out.println(title);
        System.out.println("------------------------------");
    }
}
