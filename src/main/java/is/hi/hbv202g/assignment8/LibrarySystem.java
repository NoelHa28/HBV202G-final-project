package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<User> users;
    private List<Book> books;
    private List<Lending> lendings;

    public LibrarySystem() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(this.users);
    }
    
    public List<Book> getAllBooks() {
        return new ArrayList<>(this.books);
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
        this.books.add(new Book(title, authorName));
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException {
        this.books.add(new Book(title, authors));
    }

    public void addStudentUser(String name, boolean feePaid) {
        this.users.add(new Student(name, feePaid));
    }

    public void addFacultyMemberUser(String name, String department) {
        this.users.add(new FacultyMember(name, department));
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
    }

    public void extendLending(User andri, Book book, int days) {
        for (Lending lending : this.lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(andri)) {
                lending.setDueDate(lending.getDueDate().plusDays(days));
                break;
            }
        }
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
