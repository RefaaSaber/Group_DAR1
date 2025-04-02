package cpit251_project;


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
    
}
