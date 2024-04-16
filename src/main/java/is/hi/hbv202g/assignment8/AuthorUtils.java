package is.hi.hbv202g.assignment8;

public class AuthorUtils {
    public static StringBuilder printAuthors(Book book) {
        StringBuilder authors = new StringBuilder();
        for (Author author : book.getAuthors()) {
            authors.append(author.getName()).append(", ");
        }
        // Remove the trailing comma and space
        if (authors.length() > 0) {
            authors.setLength(authors.length() - 2);
        }
        return authors;
    }
}
