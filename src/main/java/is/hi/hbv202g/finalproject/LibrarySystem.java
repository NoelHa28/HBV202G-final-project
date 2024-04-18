package is.hi.hbv202g.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibrarySystem extends Observable {
    private static LibrarySystem instance;
    private List<User> users;
    private List<Book> books;
    private List<Lending> lendings;

    private LibrarySystem() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(this.users);
    }

    public static LibrarySystem getInstance() {
        if (instance == null) {
            instance = new LibrarySystem();
        }
        return instance;
    }
    
    public List<Book> getAllBooks() {
        return new ArrayList<>(this.books);
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
        this.books.add(new Book(title, authorName));
        notifyObservers(title + " by " + authorName + " has been added to the library");
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException {
        this.books.add(new Book(title, authors));
        String authorNames = authors.stream()
                                .map(Author::getName)
                                .collect(Collectors.joining(", "));
        notifyObservers(title + " by " + authorNames + " has been added to the library");
}

    public void addStudentUser(String name, boolean feePaid) {
        this.users.add(new Student(name, feePaid));
        notifyObservers("The student user " + name + " has been added to the library. Fee paid: " + feePaid + ".");
    }

    public void addFacultyMemberUser(String name, String department) {
        this.users.add(new FacultyMember(name, department));
        notifyObservers("The faculty member user " + name + " from the department " + department + " has been added to the library");
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book with title " + title + " does not exist");
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (User user : this.users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User with name " + name + " does not exist");
    }

    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException  {
        User foundUser = findUserByName(user.getName());
        Book foundBook = findBookByTitle(book.getTitle());
    
        this.lendings.add(new Lending(foundBook, foundUser));
        notifyObservers(foundUser.getName() + " is now borrowing " + foundBook.getTitle());
    }

    public void extendLending(User andri, Book book, int days) {
        for (Lending lending : this.lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(andri)) {
                lending.setDueDate(lending.getDueDate().plusDays(days));
                break;
            }
        }
        notifyObservers(andri.getName() + " extended the lending of " + book.getTitle() + " by " + days + " days");
    }

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        Lending foundLending = null;
        for (Lending lending : this.lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                foundLending = lending;
                break;
            }
        }
        if (foundLending == null) {
            throw new UserOrBookDoesNotExistException("Book was not borrowed by this user");
        }
        this.lendings.remove(foundLending);
        notifyObservers(user.getName() + " has returned " + book.getTitle());
    }
    
    public void printLendings(User user) {
        boolean hasLendings = false;
        for (Lending lending : this.lendings) {
            if (lending.getUser().equals(user)) {
                System.out.println(lending.getBook().getTitle() +
                        " is currently borrowed by " +
                        lending.getUser().getName() +
                        " until " + lending.getDueDate());
                hasLendings = true;
            }
        }
        if (!hasLendings) {
            System.out.println(user.getName() + " has no lendings");
        }
    }
}
