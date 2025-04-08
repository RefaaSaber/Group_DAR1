package cpit251_project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TransactionFileClass {

    private final String fileName;

    public TransactionFileClass() {
        this.fileName = "transactions.txt";
    }

    public TransactionFileClass(String customFileName) {
        this.fileName = customFileName;
    }

    public void appendTransactionToFile(Transaction transaction) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(transaction.toString());
            writer.write(System.lineSeparator());
            writer.write("==========================================");
            writer.write(System.lineSeparator());
            System.out.println(" Transaction saved to file!");
        } catch (IOException e) {
            System.out.println(" Error saving transaction: " + e.getMessage());
        }
    }

    public void appendMultipleTransactions(List<Transaction> transactions) {
        for (Transaction t : transactions) {
            appendTransactionToFile(t);
        }
    }
}