
package cpit251_project;

import java.time.LocalDate;

public class Transaction {
    
   
    private String  TransactionName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Transaction(String TransactionName, LocalDate startDate, LocalDate endDate) {
        this.TransactionName = TransactionName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    

    public String getDescription() {
        return TransactionName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Transaction Name: " + TransactionName +
               "\nStart Date: " + startDate +
               "\nEnd Date: " + endDate;
    
}
}
