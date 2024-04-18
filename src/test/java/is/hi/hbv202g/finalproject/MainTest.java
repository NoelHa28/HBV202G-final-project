package is.hi.hbv202g.finalproject;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple Main.
 */
public class MainTest
{
    @Test
    public void shouldBePossibleToInstantiateLibrarySystem()
    {
        LibrarySystem librarySystem = LibrarySystem.getInstance();
        Assert.assertNotNull(librarySystem);
    }

    @Test
    public void testIfLibrarySystemIsSingleton()
    {
        LibrarySystem librarySystem1 = LibrarySystem.getInstance();
        LibrarySystem librarySystem2 = LibrarySystem.getInstance();
        Assert.assertSame(librarySystem1, librarySystem2);
    }
}
