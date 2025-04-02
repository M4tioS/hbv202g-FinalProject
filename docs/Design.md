# Design Documentation

## Class Diagram Description

The library management system consists of the following main components:

### Core Classes

- **LibrarySystem**: The main controller class that manages books, users, lendings, and omnibuses.
- **Book**: Represents a book with a title and one or more authors.
- **Author**: Represents an author of a book.
- **Lending**: Represents a lending transaction with a book, user, and due date.
- **Omnibus**: Represents a collection of books treated as a single entity.

### User Classes

- **User**: Abstract base class for library users.
- **Student**: A student user with a fee payment status.
- **FacultyMember**: A faculty member user with a department.

### Observer Pattern Classes

- **LibraryObserver**: Interface for observers that want to be notified of library events.
- **LibraryStatistics**: A concrete observer that collects statistics about borrowing patterns.

### Exception Classes

- **EmptyAuthorListException**: Thrown when attempting to create a book with no authors.
- **UserOrBookDoesNotExistException**: Thrown when operations involve non-existent users or books.

## UML Class Diagram

The UML class diagram for this project is located in the `/UML/library_system.uxf` file. _OLD DIAGRAM, NEEDS UPDATED_

## Design Patterns

### Observer Pattern

The Observer pattern is implemented to track and respond to library events:

1. **Subject**: The `LibrarySystem` class acts as the subject that maintains a list of observers and notifies them of events.

   - `addObserver(LibraryObserver observer)`: Adds an observer.
   - `removeObserver(LibraryObserver observer)`: Removes an observer.
   - `notifyBookBorrowed(Book book, User user)`: Notifies observers when a book is borrowed.
   - `notifyBookReturned(Book book, User user)`: Notifies observers when a book is returned.

2. **Observer Interface**: The `LibraryObserver` interface defines the methods that observers must implement.

   - `bookBorrowed(Book book, User user)`: Called when a book is borrowed.
   - `bookReturned(Book book, User user)`: Called when a book is returned.

3. **Concrete Observer**: The `LibraryStatistics` class implements the `LibraryObserver` interface and tracks borrowing statistics.
   - Tracks which books are borrowed most frequently.
   - Tracks which users borrow the most books.
   - Maintains counts of total borrowings and returns.

### Composite Pattern

The Composite pattern is implemented with the `Omnibus` class:

1. **Component**: Books are the basic components.
2. **Composite**: The `Omnibus` class contains a collection of books.
3. **Operations**: When operations are performed on an omnibus, they are delegated to each book:
   - `borrowOmnibus(User user, Omnibus omnibus)`: Borrows all books in the omnibus.
   - `returnOmnibus(User user, Omnibus omnibus)`: Returns all books in the omnibus.
   - `extendOmnibus(FacultyMember facultyMember, Omnibus omnibus, LocalDate newDueDate)`: Extends the lending period for all books in the omnibus.

## Architecture

The application follows a simple layered architecture:

1. **Data Layer**: The classes `Book`, `Author`, `User`, etc. represent the data model.
2. **Business Logic Layer**: The `LibrarySystem` class contains the core logic.
3. **User Interface**: _TODO_

## Data Flow

1. The `LibrarySystem` is initialized with empty collections.
2. Books and users are added to the system.
3. Users can borrow books, creating lending records.
4. Faculty members can extend lending periods.
5. Users return books, removing lending records.
6. Observers are notified of borrowing and returning events.
7. Statistics are collected and can be queried.
