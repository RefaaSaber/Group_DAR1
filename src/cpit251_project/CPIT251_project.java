package cpit251_project;

import java.util.Scanner;

public class CPIT251_project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        while (true) {
            Transaction transaction = manager.createTransaction();

            if (transaction != null) {
                TransactionFileClass transactionFile = new TransactionFileClass();
                transactionFile.appendTransactionToFile(transaction);
            }

            System.out.print("Do you want to create another transaction? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("no")) {
                System.out.println("Thank you for using the system.");
                break;
            }
        }

        scanner.close();  
    }
}