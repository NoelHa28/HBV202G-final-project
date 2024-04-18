package is.hi.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class BookTest {
    private Book book;
    private String title;

    @Before
    public void setUp() {
        String author = "Matt Yellow";
        String title = "The Da Vinci Code";
        book = new Book(title, author);
    }

    @Test
    public void testAddAndGetAuthor() {
        Author author = new Author("Dan Brown");
        book.addAuthor(author);
        assertTrue(book.getAuthors().contains(author));
    }

    @Test
    public void testGetAndSetTitle() {
        String title = "Inferno";
        book.setTitle(title);
        assertEquals(title, book.getTitle());
    }

    @Test(expected = EmptyAuthorListException.class)
    public void testBookConstructorEmptyAuthorList() throws EmptyAuthorListException {
        new Book(title, new ArrayList<>());
    }
}