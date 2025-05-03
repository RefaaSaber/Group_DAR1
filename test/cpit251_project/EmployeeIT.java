package cpit251_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeIT {

    private Employee employee;
    private Transaction transaction1;
    private Transaction transaction2;

    @Before
    public void setUp() {
        // initialize employee with name "Abrar" and transactions with LocalDate
        employee = new Employee("Abrar");
        transaction1 = new Transaction("Transaction 1", LocalDate.of(2025, 4, 21), LocalDate.of(2025, 5, 21));
        transaction2 = new Transaction("Transaction 2", LocalDate.of(2025, 4, 21), LocalDate.of(2025, 5, 21));

        // assign transactions to the employee using the assignEmployee method
        transaction1.assignEmployee("Abrar", LocalDate.of(2025, 5, 21));
        transaction2.assignEmployee("Abrar", LocalDate.of(2025, 5, 21));
    }

    //test getAssignedTransactions method
    @Test
    public void testGetAssignedTransactions() {
        System.out.println("getAssignedTransactions");
        // Ensure that the transactions are added to the employees list
        employee.receiveTransaction(transaction1);
        employee.receiveTransaction(transaction2);

        List<Transaction> expResult = new ArrayList<>();
        expResult.add(transaction1);
        expResult.add(transaction2);

        List<Transaction> result = employee.getAssignedTransactions();

        assertEquals(expResult, result);

    }

    //Test of receiveTransaction method
    @Test
    public void testReceiveTransaction() {
        System.out.println("receiveTransaction");
        employee.receiveTransaction(transaction1);
        employee.receiveTransaction(transaction2);

        assertTrue(employee.getAssignedTransactions().contains(transaction1));
        assertTrue(employee.getAssignedTransactions().contains(transaction2));
    }

    //Test of viewAssignedTransactions method
    @Test
    public void testViewAssignedTransactions() {
        System.out.println("viewAssignedTransactions");
        employee.receiveTransaction(transaction1);
        employee.receiveTransaction(transaction2);
        employee.viewAssignedTransactions();
    }
}
