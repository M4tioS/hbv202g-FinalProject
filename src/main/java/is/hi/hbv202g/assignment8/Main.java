package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class demonstrating the library management system.
 */
public class Main {
    /**
     * The main entry point of the application.
     * Creates a library system, adds some sample data, and demonstrates the functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Create the library system
            LibrarySystem library = new LibrarySystem();
            
            // Add a library statistics observer
            LibraryStatistics stats = new LibraryStatistics();
            library.addObserver(stats);
            
            // Add some books
            library.addBookWithTitleAndNameOfSingleAuthor("The Hobbit", "J.R.R. Tolkien");
            library.addBookWithTitleAndNameOfSingleAuthor("1984", "George Orwell");
            library.addBookWithTitleAndNameOfSingleAuthor("The Great Gatsby", "F. Scott Fitzgerald");
            
            // Add some books with multiple authors
            List<Author> authors = new ArrayList<>();
            authors.add(new Author("Neil Gaiman"));
            authors.add(new Author("Terry Pratchett"));
            library.addBookWithTitleAndAuthorList("Good Omens", authors);
            
            // Add users
            library.addStudentUser("John Smith", true);
            library.addStudentUser("Jane Doe", false);
            library.addFacultyMemberUser("Professor Johnson", "Computer Science");
            
            // Create an omnibus
            List<Book> bookSet = new ArrayList<>();
            bookSet.add(library.findBookByTitle("The Hobbit"));
            bookSet.add(library.findBookByTitle("1984"));
            library.addOmnibus(bookSet);
            
            // Borrow books
            User john = library.findUserByName("John Smith");
            Book book1984 = library.findBookByTitle("1984");
            library.borrowBook(john, book1984);
            
            FacultyMember professor = (FacultyMember) library.findUserByName("Professor Johnson");
            Book bookHobbit = library.findBookByTitle("The Hobbit");
            library.borrowBook(professor, bookHobbit);
            
            // Extend a lending
            library.extendLending(professor, bookHobbit, LocalDate.now().plusDays(60));
            
            // Return a book
            library.returnBook(john, book1984);
            
            // Print statistics
            System.out.println("Total borrowings: " + stats.getTotalBorrowings());
            System.out.println("Total returns: " + stats.getTotalReturns());
            
            if (stats.getMostBorrowedBook() != null) {
                System.out.println("Most borrowed book: " + stats.getMostBorrowedBook().getTitle());
            }
            
            if (stats.getMostActiveUser() != null) {
                System.out.println("Most active user: " + stats.getMostActiveUser().getName());
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
