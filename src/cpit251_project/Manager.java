
package cpit251_project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Manager {
     public Transaction createTransaction() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Transaction Name: ");
            String TransactionName = scanner.nextLine();

            System.out.print("Enter start date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter end date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            if (startDate.isAfter(endDate)) {
                System.out.println("Error: Start date must be before or equal to end date.");
                return null;
            }

            Transaction transaction = new Transaction(TransactionName, startDate, endDate);
            System.out.println("Transaction Created Successfully!");
            System.out.println(transaction);
            return transaction;

        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            return null;
        }
    }
}
    

    

