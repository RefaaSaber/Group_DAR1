package cpit251_project;

import java.time.LocalDate;

public class Transaction {

    private String transactionName;
    private LocalDate startDate;
    private LocalDate endDate;
    private static int idCounter = 1; 
    private int ID;

    public Transaction(String TransactionName, LocalDate startDate, LocalDate endDate) {
        this.transactionName = TransactionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ID = idCounter++;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    
    @Override
    public String toString() {
        return String.format("Transaction Name: %s%nStart Date: %s%nEnd Date: %s",
                transactionName, startDate, endDate);
    }

}
