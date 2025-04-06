package cpit251_project;

import java.io.FileWriter;
import java.io.IOException;

public class TransactionFileClass {

    private static final String FILE_NAME = "transactions.txt";

    public void appendTransactionToFile(Transaction transaction) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(transaction.toString() + System.lineSeparator());
            System.out.println("Transaction saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }
}
