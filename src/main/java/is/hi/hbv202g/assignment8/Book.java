package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a book in the library system.
 * A book has a title and one or more authors.
 */
public class Book {

    private String title;
    private List<Author> authors;

    /**
     * Creates a new book with a single author.
     * 
     * @param title The title of the book
     * @param authorName The name of the single author
     */
    public Book(String title, String authorName) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(new Author(authorName));
    }

    /**
     * Creates a new book with multiple authors.
     * 
     * @param title The title of the book
     * @param authors The list of authors
     * @throws EmptyAuthorListException if the author list is empty
     */
    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        this.title = title;
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list is empty");
        }
        this.authors = authors;
    }

    /**
     * Gets the title of the book.
     * 
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     * 
     * @param title The new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the list of authors.
     * 
     * @return The list of authors
     */
    public List<Author> getAuthors(){
        return authors;
    }

    /**
     * Sets the list of authors.
     * 
     * @param authors The new list of authors
     * @throws EmptyAuthorListException if the author list is empty
     */
    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list is empty");
        }
        this.authors = authors;
    }

    /**
     * Adds an author to the book.
     * 
     * @param author The author to add
     */
    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new ArrayList<>();
        }
        this.authors.add(author);
    }
}