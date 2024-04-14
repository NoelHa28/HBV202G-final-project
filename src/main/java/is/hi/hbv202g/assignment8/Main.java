package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/*
 * This main function shows some abilities of the library system class
 * 
 */
public class Main
{
    public static void main( String[] args ) throws EmptyAuthorListException, UserOrBookDoesNotExistException
    {
        LibrarySystem myLibrarySystem = new LibrarySystem();
        myLibrarySystem.addStudentUser("Noëlla Hilgen", true);
        myLibrarySystem.addFacultyMemberUser("Andri Gudjohnsen", "Computer Science");
        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Harry Potter and the Philosopher's Stone",
                "J.K. Rowling");
        List<Author> authorsbook2 = new ArrayList<>();
        authorsbook2.add(new Author("Thomas H. Cormen"));
        authorsbook2.add(new Author("Charles E. Leiserson"));
        authorsbook2.add(new Author("Ronald L. Rivest"));
        authorsbook2.add(new Author("Clifford Stein"));
        myLibrarySystem.addBookWithTitleAndAuthorList("Introduction to Algorithms", authorsbook2);
        User Noella = myLibrarySystem.findUserByName("Noëlla Hilgen");
        User Andri = myLibrarySystem.findUserByName("Andri Gudjohnsen");
        Book HarryP = myLibrarySystem.findBookByTitle("Harry Potter and the Philosopher's Stone");
        Book Intro = myLibrarySystem.findBookByTitle("Introduction to Algorithms");
        myLibrarySystem.borrowBook(Noella, HarryP);
        myLibrarySystem.borrowBook(Andri, Intro);
        myLibrarySystem.printLendings(Noella);
        myLibrarySystem.printLendings(Andri);
        myLibrarySystem.extendLending((FacultyMember) Andri, Intro, LocalDate.now().plusDays(60));
        myLibrarySystem.returnBook(Noella, HarryP);
        myLibrarySystem.printLendings(Noella);
        myLibrarySystem.printLendings(Andri);
    }
}
