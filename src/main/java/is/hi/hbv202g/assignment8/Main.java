package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

/*
 * This main function shows some abilities of the library system class
 * 
 */
public class Main
{
    public static void main( String[] args ) throws EmptyAuthorListException, UserOrBookDoesNotExistException
    {
        LibrarySystem myLibrarySystem = new LibrarySystem();
        myLibrarySystem.addStudentUser("Noella Hilgen", true);
        myLibrarySystem.addFacultyMemberUser("Andri Gudjohnsen", "Computer Science");
        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Harry Potter and the Philosopher's Stone",
                "J.K. Rowling");
        List<Author> authorsbook2 = new ArrayList<>();
        authorsbook2.add(new Author("Thomas H. Cormen"));
        authorsbook2.add(new Author("Charles E. Leiserson"));
        authorsbook2.add(new Author("Ronald L. Rivest"));
        authorsbook2.add(new Author("Clifford Stein"));
        myLibrarySystem.addBookWithTitleAndAuthorList("Introduction to Algorithms", authorsbook2);

        // Initialize the UI with the library system
        LibrarySystemUI ui = new LibrarySystemUI(myLibrarySystem);

        // Start the UI
        ui.start();
    }
}
