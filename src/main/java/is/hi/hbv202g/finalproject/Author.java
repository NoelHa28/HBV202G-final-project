package is.hi.hbv202g.finalproject;

/**
 * Class that represents an author's name.
 */
public class Author {
    private String name;

    /**
     * Creates a new Author with the given name.
     *
     * @param name the name of the author
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the author.
     *
     * @return the name of the author
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the author.
     *
     * @param name the new name of the author
     */
    public void setName(String name) {
        this.name = name;
    }
}
