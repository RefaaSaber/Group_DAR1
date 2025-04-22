/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cpit251_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ruba
 */
public class TransactionFileClassIT {
    
    public TransactionFileClassIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of appendTransactionToFile method, of class TransactionFileClass.
     */
    @Test
    public void testAppendTransactionToFile() {
        System.out.println("appendTransactionToFile");
       Transaction transaction = new Transaction("Test Transaction", 
                                              LocalDate.of(2024, 1, 1), 
                                              LocalDate.of(2024, 1, 10));
       TransactionFileClass instance = new TransactionFileClass();
       instance.appendTransactionToFile(transaction);
        
    }

    /**
     * Test of overwriteAllTransactions method, of class TransactionFileClass.
     */
    @Test
    public void testOverwriteAllTransactions() {
        System.out.println("overwriteAllTransactions");
        List<Transaction> transactions = new ArrayList<>();
    transactions.add(new Transaction("Test Transaction 1", 
                                     LocalDate.of(2024, 2, 1), 
                                     LocalDate.of(2024, 2, 5)));

    transactions.add(new Transaction("Test Transaction 2", 
                                     LocalDate.of(2024, 3, 1), 
                                     LocalDate.of(2024, 3, 10)));

    TransactionFileClass instance = new TransactionFileClass();
    instance.overwriteAllTransactions(transactions);
    }
    
}
