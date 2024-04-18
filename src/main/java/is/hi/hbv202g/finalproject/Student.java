package is.hi.hbv202g.finalproject;

/**
 * Class that represents a student user in the system with a name and whether they have paid their fee.
 * Student is a subclass of User.
 */
public class Student extends User {

    /**
     * Indicates whether the student has paid their fee.
     */
    private boolean feePaid;

    /**
     * Constructs a new Student object.
     *
     * @param name the name of the student
     * @param feePaid whether the student has paid their fee
     */
    public Student(String name, boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
    }

    /**
     * Returns whether the student has paid their fee.
     *
     * @return true if the student has paid their fee, false otherwise
     */
    public boolean isFeePaid() {
        return this.feePaid;
    }

    /**
     * Sets whether the student has paid their fee.
     *
     * @param feePaid whether the student has paid their fee
     */
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}
