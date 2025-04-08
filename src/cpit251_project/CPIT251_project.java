package cpit251_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPIT251_project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        List<Transaction> allTransactions = new ArrayList<>();

        System.out.println("==================================");
        System.out.println("Welcome to the Transaction System!");
        System.out.println("==================================");

        while (true) {
            System.out.print("\nAre you a (1) Manager, (2) Employee, or (3) Exit? ");
            String role = scanner.nextLine().trim();

            if (role.equals("1")) {
                System.out.println("\n--- Manager Section ---");
                Transaction transaction = manager.createTransaction();

                if (transaction != null) {
                    allTransactions.add(transaction);
                    new TransactionFileClass().appendTransactionToFile(transaction);
                    System.out.println("Transaction successfully created and saved.");
                }
                System.out.println("--- End of Manager Section ---");

            } else if (role.equals("2")) {
                System.out.println("\n--------- Employee Section ---------");
                System.out.print("Enter your name: ");
                String employeeName = scanner.nextLine().trim();
                Employee employee = new Employee(employeeName);

              
                for (Transaction t : allTransactions) {
                    for (EmployeeAssignment assignedEmployee : t.getAssignedEmployees()) {
                        if (assignedEmployee.getEmployeeName().equalsIgnoreCase(employeeName)) {
                            employee.receiveTransaction(t);  
                            break;  
                        }
                    }
                }
               
                employee.viewAssignedTransactions();
                System.out.println("--------- End of Employee Section ---------");
                
                
            } else if (role.equals("3")) {
                System.out.println("Thank you for using the system.");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }

            System.out.println("==================================");
        }

        scanner.close();
    }
}

        scanner.close();
    }
}
