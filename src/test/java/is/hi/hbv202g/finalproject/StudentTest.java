package is.hi.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student("Noella Hilgen", true);
    }

    @Test
    public void testIsFeePaid() {
        assertTrue(student.isFeePaid());
    }

    @Test
    public void testSetFeePaid() {
        student.setFeePaid(false);
        assertFalse(student.isFeePaid());
    }

    @Test
    public void testGetName() {
        assertEquals("Noella Hilgen", student.getName());
    }

    @Test
    public void testSetName() {
        student.setName("Kristofer Cardoso");
        assertEquals("Kristofer Cardoso", student.getName());
    }
}