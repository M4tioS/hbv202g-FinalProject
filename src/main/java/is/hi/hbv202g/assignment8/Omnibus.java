package is.hi.hbv202g.assignment8;

import java.util.List;

public class Omnibus {
    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    public Omnibus(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book with title " + title + " does not exist");
    }

    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (!books.contains(book)) {
            throw new UserOrBookDoesNotExistException("Book does not exist");
        }

        if (!users.contains(user)) {
            throw new UserOrBookDoesNotExistException("User does not exist");
        }
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

}
