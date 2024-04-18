package is.hi.hbv202g.finalproject;

import java.util.ArrayList;
import java.util.List;

/*
 * This main function creates a simple library system and starts the UI.
 * 
 */
public class Main
{
    /**
     * The main entry point for the application.
     * This method creates a library system, adds some initial data to it, and starts the UI.
     *
     * @param args command-line arguments (not used)
     * @throws EmptyAuthorListException if an attempt is made to create a book with an empty list of authors
     * @throws UserOrBookDoesNotExistException if a user or book does not exist in the system
     */
    public static void main( String[] args ) throws EmptyAuthorListException, UserOrBookDoesNotExistException
    {
        LibrarySystem myLibrarySystem = LibrarySystem.getInstance();
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
        NewLibrarySystemUI ui = new NewLibrarySystemUI(myLibrarySystem);

        // Start the UI
        ui.start();
    }
}
