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
        List<EmployeeAssignment> assignments = transaction.getAssignedEmployees();

        for (int i = 0; i < assignments.size(); i++) {
            EmployeeAssignment ea = assignments.get(i);
            if (ea.getEmployeeName().equalsIgnoreCase(name)) {
                assignedTransactions.add(transaction);
                break;
            }
        }
    }
}
