package is.hi.hbv202g.finalproject;

/**
 * This abstract class represents a user in the system.
 * It can be subclassed to represent specific types of users.
 */
public abstract class User {

    /**
     * The name of the user.
     */
    private String name;

    /**
     * Constructs a new User object.
     *
     * @param name the name of the user
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }
}