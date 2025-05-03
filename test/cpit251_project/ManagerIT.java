package cpit251_project;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class ManagerIT {

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
            String input = promptText(prompt);
            return input.isEmpty() ? null : LocalDate.parse(input);
        }
    }

    @Test
    public void testCreateTransactionOnly_ValidInput() {
        String[] simulatedInputs = {
            "Project Alpha",
            "2025-04-15",
            "2025-04-20",
            "Initial planning phase",
            "Ali",
            "2025-04-18",
            "done"
        };

        Manager manager = new ManagerTestable(simulatedInputs);
        Transaction transaction = manager.createTransactionOnly();

        assertNotNull(transaction);
        assertEquals("Project Alpha", transaction.getTransactionName());
        assertEquals(LocalDate.of(2025, 4, 15), transaction.getStartDate());
        assertEquals(LocalDate.of(2025, 4, 20), transaction.getEndDate());
        assertEquals("Initial planning phase", transaction.getContent());

        assertEquals(1, transaction.getAssignedEmployees().size());
        assertEquals("Ali", transaction.getAssignedEmployees().get(0).getEmployeeName());
        assertEquals(LocalDate.of(2025, 4, 18), transaction.getAssignedEmployees().get(0).getDeadline());
    }

    @Test
    public void testCreateTransactionOnly_InvalidDateOrder() {
        String[] simulatedInputs = {
            "Project Beta",
            "2025-05-01",
            "2025-04-25",};

        Manager manager = new ManagerTestable(simulatedInputs);
        Transaction transaction = manager.createTransactionOnly();

        assertNull(transaction);
    }
}
