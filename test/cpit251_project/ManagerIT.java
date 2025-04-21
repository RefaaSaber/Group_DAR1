package cpit251_project;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class ManagerIT {

    // ✅ Inner class for testable Manager
    private static class ManagerTestable extends Manager {

        private final String[] inputs;
        private int currentIndex = 0;

        public ManagerTestable(String... inputs) {
            this.inputs = inputs;
        }

        @Override
        protected String promptText(String prompt) {
            return currentIndex < inputs.length ? inputs[currentIndex++] : "";
        }

        @Override
        protected LocalDate promptDate(String prompt) {
            while (true) {
                try {
                    return LocalDate.parse(promptText(prompt));
                } catch (Exception e) {

                    if (currentIndex >= inputs.length) {
                        throw new RuntimeException("No more test input available for date parsing.");
                    }
                }
            }
        }

    }

    // ✅ Test 1
    @Test
    public void testCreateTransactionOnly_ValidInput() {
        String[] simulatedInputs = {
            "Project Alpha", "2025-04-15", "2025-04-20", "Initial planning phase"
        };

        Manager manager = new ManagerTestable(simulatedInputs);
        Transaction transaction = manager.createTransactionOnly();

        assertNotNull(transaction);
        assertEquals("Project Alpha", transaction.getTransactionName());
        assertEquals(LocalDate.of(2025, 4, 15), transaction.getStartDate());
        assertEquals(LocalDate.of(2025, 4, 20), transaction.getEndDate());
        assertEquals("Initial planning phase", transaction.getContent());
    }

    // ✅ Test 2
    @Test
    public void testCreateTransactionOnly_InvalidDateOrder() {
        String[] simulatedInputs = {
            "Project Beta", "2025-05-01", "2025-04-25", "This shouldn't matter"
        };

        Manager manager = new ManagerTestable(simulatedInputs);
        Transaction transaction = manager.createTransactionOnly();

        assertNull(transaction);
    }

    // ✅ Test 3
    @Test
    public void testAssignEmployeesToExistingTransaction_Valid() {
        Transaction transaction = new Transaction("Task X", LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 30));
        String[] simulatedInputs = {"Sarah", "2025-04-20", "done"};

        Manager manager = new ManagerTestable(simulatedInputs);
        manager.assignEmployeesToExistingTransaction(transaction);

        assertEquals(1, transaction.getAssignedEmployees().size());
        assertEquals("Sarah", transaction.getAssignedEmployees().get(0).getEmployeeName());
    }

    // ✅ Test 4
    @Test
    public void testAssignEmployeesToExistingTransaction_NullTransaction() {
        Manager manager = new ManagerTestable();
        manager.assignEmployeesToExistingTransaction(null);  // No exception should occur
    }

    // ✅ Test 4
    @Test
    public void testPromptDate_ValidDate() {
        ManagerTestable manager = new ManagerTestable("2025-04-25");
        LocalDate date = manager.promptDate("Enter date:");
        assertEquals(LocalDate.of(2025, 4, 25), date);
    }

    // ✅ Test 4
    @Test
    public void testPromptDate_InvalidThenValid() {
        ManagerTestable manager = new ManagerTestable("not-a-date", "2025-04-10");
        LocalDate date = manager.promptDate("Enter date:");
        assertEquals(LocalDate.of(2025, 4, 10), date);
    }

}
