package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;
    private List<Omnibus> omnibuses;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
        this.omnibuses = new ArrayList<>();
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName){
        Book book = new Book(title, authorName);
        books.add(book);
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException {
        Book book = new Book(title, authors);
        books.add(book);
    }

    public void addStudentUser(String name, boolean feePaid) {
        User user = new Student(name, feePaid);
        users.add(user);
    }

    public void addFacultyMemberUser(String name, String department) {
        User user = new FacultyMember(name, department);
        users.add(user);
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book with title " + title + " does not exist");
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User with name " + name + " does not exist");
    }

    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (!books.contains(book)) {
            throw new UserOrBookDoesNotExistException("Book does not exist");
        }

        if (!users.contains(user)){
            throw new UserOrBookDoesNotExistException("User does not exist");
        }
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }



    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
        boolean found = false;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(facultyMember)) {
                lending.setDueDate(newDueDate);
                found = true;
                return;
            }
        }

        if (!found){
            throw new UserOrBookDoesNotExistException("Book was not borrowed by faculty member");
        }
    }

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {

        boolean found = false;

        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                lendings.remove(lending);
                found = true;
                return;
            }
        }

        if (!found) {
            throw new UserOrBookDoesNotExistException("Book was not borrowed");
        }
    }

    public void addOmnibus(List<Book> books) {
        Omnibus omnibus = new Omnibus(books);
        omnibuses.add(omnibus);
    }

    public void borrowOmnibus(User user, Omnibus omnibus) throws UserOrBookDoesNotExistException {
        if (!omnibuses.contains(omnibus)) {
            throw new UserOrBookDoesNotExistException("Omnibus does not exist");
        }

        if (!users.contains(user)){
            throw new UserOrBookDoesNotExistException("User does not exist");
        }
        for (Book book : omnibus.getBooks()) {
            Lending lending = new Lending(book, user);
            lendings.add(lending);
        }
    }


    public void returnOmnibus(User user, Omnibus omnibus) throws UserOrBookDoesNotExistException {
        if (!omnibuses.contains(omnibus)) {
            throw new UserOrBookDoesNotExistException("Omnibus does not exist");
        }
        if (!users.contains(user)){
            throw new UserOrBookDoesNotExistException("User does not exist");
        }
        for (Book book : omnibus.getBooks()) {
            Lending lending = new Lending(book, user);
            lendings.remove(lending);
        }
    }

    public void extendOmnibus(FacultyMember facultyMember, Omnibus omnibus, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
        if (!omnibuses.contains(omnibus)) {
            throw new UserOrBookDoesNotExistException("Omnibus does not exist");
        }
        for (Book book : omnibus.getBooks()) {
            Lending lending = new Lending(book, facultyMember);
            lending.setDueDate(newDueDate);
        }
    }

}
