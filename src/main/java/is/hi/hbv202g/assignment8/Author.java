package is.hi.hbv202g.assignment8;

/**
 * Represents an author of a book in the library system.
 * An author has a name.
 */
public class Author {
    private String name;

    /**
     * Creates a new author with the given name.
     * 
     * @param name The name of the author
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the author.
     * 
     * @return The author's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the author.
     * 
     * @param name The new name for the author
     */
    public void setName(String name) {
        this.name = name;
    }

}
