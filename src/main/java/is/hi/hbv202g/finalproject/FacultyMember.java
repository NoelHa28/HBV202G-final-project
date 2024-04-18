package is.hi.hbv202g.finalproject;

/**
 * Represents a faculty member with a name and a department.
 * FacultyMember is a subclass of User.
 */
public class FacultyMember extends User {
    private String department;

    /**
     * Creates a new FacultyMember with the given name and department.
     *
     * @param name the name of the faculty member
     * @param department the department of the faculty member
     */
    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }

    /**
     * Returns the department of the faculty member.
     *
     * @return the department of the faculty member
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Sets the department of the faculty member.
     *
     * @param department the new department of the faculty member
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
