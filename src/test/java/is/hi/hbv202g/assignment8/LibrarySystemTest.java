package is.hi.hbv202g.assignment8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibrarySystemTest {
    private LibrarySystem librarySystem;

    @Before
    public void setUp() {
        librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("Kristofer", true);
        librarySystem.addFacultyMemberUser("Andri", "Computer Science");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("Dune", "Frank Herbert");
    }

    @Test
    public void testStudentUser() throws UserOrBookDoesNotExistException {
        User user = librarySystem.findUserByName("Kristofer");
        assertNotNull(user);
    }

    @Test
    public void testFacultyMemberUser() throws UserOrBookDoesNotExistException {
        User user = librarySystem.findUserByName("Andri");
        assertNotNull(user);
    }

    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testUserNotFound() throws UserOrBookDoesNotExistException {
        librarySystem.findUserByName("Chewbacca");
    }

    @Test
    public void testBookWithSingleAuthor() throws UserOrBookDoesNotExistException {
        Book book = librarySystem.findBookByTitle("Dune");
        assertNotNull(book);
    }

    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testBookNotFound() throws UserOrBookDoesNotExistException {
        librarySystem.findBookByTitle("Basics of Biochemistry");
    }
}