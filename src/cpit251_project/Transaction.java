package cpit251_project;

import java.time.LocalDate;

public class Transaction {

    private String transactionName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Transaction(String TransactionName, LocalDate startDate, LocalDate endDate) {
        this.transactionName = TransactionName;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return String.format("Transaction Name: %s%nStart Date: %s%nEnd Date: %s",
                transactionName, startDate, endDate);
    }

}
