package cpit251_project;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import static org.junit.Assert.*;

public class TransactionTest {


    @Test
    public void testTransactionInitialization() {
        Transaction t = new Transaction("Test Transaction", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));

        assertEquals("Test Transaction", t.getTransactionName());
        assertEquals(LocalDate.of(2023, 1, 1), t.getStartDate());
        assertEquals(LocalDate.of(2023, 12, 31), t.getEndDate());
        assertNotNull(t.getID());
        assertTrue(t.getID().startsWith("Transaction-"));
    }

    @Test
    public void testUniqueIDs() {
        Set<String> ids = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            Transaction t = new Transaction("T" + i, LocalDate.now(), LocalDate.now().plusDays(1));
            assertTrue("Duplicate ID found: " + t.getID(), ids.add(t.getID()));
        }
    }

    @Test
    public void testAssignEmployee() {
        Transaction t = new Transaction("HR", LocalDate.now(), LocalDate.now().plusDays(10));
        t.assignEmployee("Ali", LocalDate.now().plusDays(5));

        List<EmployeeAssignment> assigned = t.getAssignedEmployees();
        assertEquals(1, assigned.size());
        assertEquals("Ali", assigned.get(0).getEmployeeName());
        assertEquals(LocalDate.now().plusDays(5), assigned.get(0).getDeadline());
    }

    @Test
    public void testToStringIncludesTransactionDetails() {
        Transaction t = new Transaction("Finance", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28));
        t.assignEmployee("Sara", LocalDate.of(2023, 2, 20));

        String output = t.toString();

        assertTrue(output.contains("Transaction ID:"));
        assertTrue(output.contains("Transaction Name: Finance"));
        assertTrue(output.contains("Start Date: 2023-02-01"));
        assertTrue(output.contains("End Date: 2023-02-28"));
        assertTrue(output.contains("Sara"));
    }
}
