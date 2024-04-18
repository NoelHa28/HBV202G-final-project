package is.hi.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FacultyMemberTest {
    private FacultyMember facultyMember;

    @Before
    public void setUp() {
        facultyMember = new FacultyMember("Andri", "Computer Science");
    }

    @Test
    public void testGetDepartment() {
        assertEquals("Computer Science", facultyMember.getDepartment());
    }

    @Test
    public void testSetDepartment() {
        facultyMember.setDepartment("Mathematics");
        assertEquals("Mathematics", facultyMember.getDepartment());
    }

    @Test
    public void testGetName() {
        assertEquals("Andri", facultyMember.getName());
    }

    @Test
    public void testSetName() {
        facultyMember.setName("Kristofer");
        assertEquals("Kristofer", facultyMember.getName());
    }
}