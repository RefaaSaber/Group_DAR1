

package cpit251_project;

import java.util.Scanner;

public class CPIT251_project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        // Loop to ask if the user wants to create another transaction
        while (true) {
            Transaction transaction = manager.createTransaction();

            if (transaction != null) {
                TransactionFileClass transactionFile = new TransactionFileClass();
                transactionFile.saveToFile(transaction);
            }

            // Ask the user if they want to create another transaction
            System.out.print("Do you want to create another transaction? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("no")) {
                System.out.println("Thank you for using the system.");
                break;  // Exit the loop if the answer is "no"
            }
        }

        scanner.close();  
    }
}

