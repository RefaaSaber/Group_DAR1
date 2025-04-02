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
    private static List<String> generatedIDs = new ArrayList<>();  // List to track generated IDs

    // Constructor
    public Transaction(String transactionName, LocalDate startDate, LocalDate endDate) {
        this.transactionName = transactionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ID = generateUniqueID();  // Generate a unique ID
    
    }

   
   // Generate a unique transaction ID by checking manually for duplicates
    private static String generateUniqueID() {
        String newID = "Transaction-" + idCounter++;  // Generate ID
        // Check if the ID already exists in the list
        while (generatedIDs.contains(newID)) {
            newID = "Transaction-" + idCounter++;  // Generate a new ID if duplicate found
        }
        generatedIDs.add(newID);  // Add the new unique ID to the list
        return newID;  // Return the unique ID
    }

    // Getter methods
    public String getID() {
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

    // Setter methods
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
