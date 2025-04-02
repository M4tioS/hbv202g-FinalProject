package is.hi.hbv202g.assignment8;

/**
 * Abstract base class for library users.
 * Provides common functionality for all types of users.
 */
public abstract class User {
    private String name;

    /**
     * Creates a new user with the specified name.
     * 
     * @param name The name of the user
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the user.
     * 
     * @return The user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * 
     * @param name The new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
