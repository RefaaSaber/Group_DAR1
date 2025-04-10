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
                boolean backToMain = false;

                while (!backToMain) {
                    System.out.println("\n--- Manager Options ---");
                    System.out.println("1. Create New Transaction");
                    System.out.println("2. Assign Employees to a Transaction");
                    System.out.println("3. View All Transactions");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("Select an option: ");
                    String option = scanner.nextLine().trim();

                    if (option.equals("1")) {
                        Transaction newTransaction = manager.createTransactionOnly();
                        if (newTransaction != null) {
                            allTransactions.add(newTransaction);
                            new TransactionFileClass().appendTransactionToFile(newTransaction);
                        }

                    } else if (option.equals("2")) {
                        if (allTransactions.isEmpty()) {
                            System.out.println("No transactions available.");
                        } else {
                            System.out.println("Available Transactions:");
                            for (int i = 0; i < allTransactions.size(); i++) {
                                System.out.println((i + 1) + ". " + allTransactions.get(i).getTransactionName());
                            }

                            System.out.print("Enter the number of the transaction to assign employees: ");
                            String indexInput = scanner.nextLine().trim();

                            try {
                                int index = Integer.parseInt(indexInput) - 1;
                                if (index >= 0 && index < allTransactions.size()) {
                               manager.assignEmployeesToExistingTransaction(allTransactions.get(index));
                              new TransactionFileClass().overwriteAllTransactions(allTransactions);
                           } else {
                           System.out.println("Invalid selection.");
                           }


                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number.");
                            }
                        }

                    } else if (option.equals("3")) {
                        if (allTransactions.isEmpty()) {
                            System.out.println("No transactions to display.");
                        } else {
                            for (Transaction t : allTransactions) {
                                System.out.println(t);
                                System.out.println("-----------------------------------");
                            }
                        }

                    } else if (option.equals("4")) {
                        backToMain = true;

                    } else {
                        System.out.println("Invalid option.");
                    }
                }

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
