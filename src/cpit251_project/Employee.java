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
}
