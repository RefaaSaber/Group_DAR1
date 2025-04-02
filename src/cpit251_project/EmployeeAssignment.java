package cpit251_project;

import java.time.LocalDate;

public class EmployeeAssignment {
    private String employeeName;
    private LocalDate deadline;

    public EmployeeAssignment(String employeeName, LocalDate deadline) {
        this.employeeName = employeeName;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, Deadline: %s", employeeName, deadline);
    }
}