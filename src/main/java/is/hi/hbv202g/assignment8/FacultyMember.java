package is.hi.hbv202g.assignment8;

/**
 * Represents a faculty member user in the library system.
 * A faculty member has a name and belongs to a department.
 */
public class FacultyMember extends User {

    private String department;

    /**
     * Creates a new faculty member with the specified name and department.
     * 
     * @param name The name of the faculty member
     * @param department The department the faculty member belongs to
     */
    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }

    /**
     * Gets the department of the faculty member.
     * 
     * @return The department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the faculty member.
     * 
     * @param department The new department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

}
