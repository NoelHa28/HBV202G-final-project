package is.hi.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class LendingTest {
    private Lending lending;
    private Book book;
    private User user;

    @Before
    public void setUp() {
        book = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling");
        user = new Student("Noella Hilgen", true);
        lending = new Lending(book, user);
    }

    @Test
    public void testLendingConstructor() {
        assertEquals(book, lending.getBook());
        assertEquals(user, lending.getUser());
        assertEquals(LocalDate.now().plusDays(30), lending.getDueDate());
    }

    @Test
    public void testGetAndSetBook() {
        Book newBook = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling");
        lending.setBook(newBook);
        assertEquals(newBook, lending.getBook());
    }

    @Test
    public void testGetAndSetUser() {
        User newUser = new FacultyMember("Andri Gudjohnsen", "Computer Science");
        lending.setUser(newUser);
        assertEquals(newUser, lending.getUser());
    }

    @Test
    public void testGetAndSetDueDate() {
        LocalDate newDueDate = LocalDate.now().plusDays(60);
        lending.setDueDate(newDueDate);
        assertEquals(newDueDate, lending.getDueDate());
    }
}