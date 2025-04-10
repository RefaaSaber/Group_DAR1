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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transaction> getAssignedTransactions() {
        return assignedTransactions;
    }

    public void setAssignedTransactions(List<Transaction> transactions) {
        this.assignedTransactions = transactions;
    }
    
public boolean isAssignedToTransaction(Transaction transaction) {
    for (EmployeeAssignment assignment : transaction.getAssignedEmployees()) {
        if (assignment.getEmployeeName().equalsIgnoreCase(name)) {
            return true;
        }
    }
    return false;
}



   public void receiveTransaction(Transaction transaction) {
    if (isAssignedToTransaction(transaction) && !assignedTransactions.contains(transaction)) {
        assignedTransactions.add(transaction);
    }
}
   
   

    public void viewAssignedTransactions() {
        System.out.println("Transactions assigned to " + name + ":");
        if (assignedTransactions.isEmpty()) {
            System.out.println("No transactions assigned.");
        } else {
            for (Transaction t : assignedTransactions) {
                System.out.println(t);
                System.out.println("---------------------------------");
            }
        }
    }

}