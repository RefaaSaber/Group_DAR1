import cpit251_project.EmployeeAssignment;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeAssignmentTest {

   
    @Test
    public void testGetEmployeeName() {
        EmployeeAssignment instance = new EmployeeAssignment("Leen", LocalDate.of(2025, 5, 1));
        String expected = "Leen";
        String actual = instance.getEmployeeName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDeadline() {
        LocalDate deadline = LocalDate.of(2025, 5, 1);
        EmployeeAssignment instance = new EmployeeAssignment("Leen", deadline);
        assertEquals(deadline, instance.getDeadline());
    }

   
    @Test
    public void testSetEmployeeName() {
        EmployeeAssignment instance = new EmployeeAssignment("OldName", LocalDate.of(2025, 5, 1));
        instance.setEmployeeName("NewName");
        assertEquals("NewName", instance.getEmployeeName());
    }

   
    @Test
    public void testSetDeadline() {
        EmployeeAssignment instance = new EmployeeAssignment("Leen", LocalDate.of(2025, 5, 1));
        LocalDate newDeadline = LocalDate.of(2025, 6, 15);
        instance.setDeadline(newDeadline);
        assertEquals(newDeadline, instance.getDeadline());
    }

   
    @Test
    public void testToString() {
        EmployeeAssignment instance = new EmployeeAssignment("Leen", LocalDate.of(2025, 5, 1));
        String expected = "Employee: Leen, Deadline: 2025-05-01";
        assertEquals(expected, instance.toString());
    }
}
