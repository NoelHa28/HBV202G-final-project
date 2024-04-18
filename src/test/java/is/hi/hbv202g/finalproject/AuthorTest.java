package is.hi.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthorTest {
    private Author author;

    @Before
    public void setUp() {
        author = new Author("Dan Brown");
    }

    @Test
    public void testGetName() {
        assertEquals("Dan Brown", author.getName());
    }

    @Test
    public void testSetName() {
        author.setName("J.R.R. Tolkien");
        assertEquals("J.R.R. Tolkien", author.getName());
    }
}