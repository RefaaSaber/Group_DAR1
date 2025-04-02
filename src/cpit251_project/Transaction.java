package cpit251_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private String transactionName;
    private LocalDate startDate;
    private LocalDate endDate;
    private static int idCounter = 1;
    private final String ID;
    private static List<String> generatedIDs = new ArrayList<>();
    private List<EmployeeAssignment> assignedEmployees = new ArrayList<>();

    public Transaction(String transactionName, LocalDate startDate, LocalDate endDate) {
        this.transactionName = transactionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ID = generateUniqueID();
    }

    private static String generateUniqueID() {
        String newID = "Transaction-" + idCounter++;
        while (generatedIDs.contains(newID)) {
            newID = "Transaction-" + idCounter++;
        }
        generatedIDs.add(newID);
        return newID;
    }

    public void assignEmployee(String employeeName, LocalDate deadline) {
        assignedEmployees.add(new EmployeeAssignment(employeeName, deadline));
    }

    public List<EmployeeAssignment> getAssignedEmployees() {
        return assignedEmployees;
    }

    public String getID() { return ID; }
    public String getTransactionName() { return transactionName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("------------------------------");
        sb.append("Transaction ID: ").append(ID)
          .append("\nTransaction Name: ").append(transactionName)
          .append("\nStart Date: ").append(startDate)
          .append("\nEnd Date: ").append(endDate)
          .append("\nAssigned Employees: ");

        if (assignedEmployees.isEmpty()) {
            sb.append("No employees assigned.");
        } else {
            for (EmployeeAssignment ea : assignedEmployees) {
                sb.append("\n").append(ea);
            }
        }
        return sb.toString();
    }
}
