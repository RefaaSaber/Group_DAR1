package cpit251_project;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private List<Transaction> assignedTransactions;

    public Employee(String name) {
        this.name = name;
        this.assignedTransactions = new ArrayList<>();
    }

    public void receiveTransaction(Transaction transaction) {
        for (EmployeeAssignment assignedName : transaction.getAssignedEmployees()) {
            if (assignedName.getEmployeeName().equalsIgnoreCase(name)) {
                assignedTransactions.add(transaction);
                break;
            }
        }
    }

    public void viewAssignedTransactions() {
        System.out.println("Transactions assigned to " + name + ":");
        if (assignedTransactions.isEmpty()) {
            System.out.println("No transactions assigned.");
        } else {
            for (Transaction t : assignedTransactions) {
                System.out.println(t); // prints details via toString()
                System.out.println("---------------------------------");
            }
        }
    }
}
