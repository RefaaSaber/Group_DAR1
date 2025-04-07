package cpit251_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPIT251_project {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Manager manager = new Manager();

        List<Transaction> allTransactions = new ArrayList<>();

        while (true) {

            System.out.println("Are you a (1) Manager or (2) Employee? (3 to Exit)");

            String role = scanner.nextLine().trim();

            if (role.equals("1")) {

                Transaction transaction = manager.createTransaction();

                if (transaction != null) {

                    allTransactions.add(transaction);

                    TransactionFileClass transactionFile = new TransactionFileClass();

                    transactionFile.appendTransactionToFile(transaction);
                }

            } else if (role.equals("2")) {

                System.out.print("Enter your name: ");

                String employeeName = scanner.nextLine().trim();

                Employee employee = new Employee(employeeName);

                for (Transaction t : allTransactions) {

                    employee.receiveTransaction(t);
                }

                employee.viewAssignedTransactions();

            } else if (role.equals("3")) {

                System.out.println("Thank you for using the system.");

                break;

            } else {

                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
