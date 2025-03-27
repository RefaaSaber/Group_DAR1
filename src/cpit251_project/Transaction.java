package cpit251_project;

import java.time.LocalDate;

public class Transaction {

    private String transactionName;
    private LocalDate startDate;
    private LocalDate endDate;
    private static int idCounter = 1;
    private final String ID; 

    public Transaction(String transactionName, LocalDate startDate, LocalDate endDate) {
        this.transactionName = transactionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ID = generateID();
    }
    
    private static synchronized String generateID() {
        return System.currentTimeMillis() + "-" + idCounter++;


    }
    
    public String getID(){
        return ID;
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
          return String.format("Transaction ID: %s%nTransaction Name: %s%nStart Date: %s%nEnd Date: %s",
            ID, transactionName, startDate, endDate);
    }
}