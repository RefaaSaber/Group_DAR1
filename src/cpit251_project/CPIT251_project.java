
package cpit251_project;


public class CPIT251_project {

    
    public static void main(String[] args) {
         Manager manager = new Manager();
       Transaction transaction = manager.createTransaction();

        if (transaction != null) {
            TransactionFileClass transactionFile = new TransactionFileClass();
            transactionFile.saveToFile(transaction);
        }
    }
    
}
