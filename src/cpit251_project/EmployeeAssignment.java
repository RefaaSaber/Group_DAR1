package cpit251_project;

import java.time.LocalDate;

public class EmployeeAssignment {

    private String employeeName;
    private LocalDate deadline;

    public EmployeeAssignment(String employeeName, LocalDate deadline) {
        this.employeeName = employeeName;
        this.deadline = deadline;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
    
public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
}


public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
}
    @Override
    public String toString() {
    return "Employee: " + employeeName + ", Deadline: " + deadline;
}
}