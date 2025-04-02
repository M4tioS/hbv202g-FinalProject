# Library Management System

A library management software system for the HBV202G final project. This software implements a library system with books, users (students and faculty members), and lending functionality.

## Team Members

- Dorian Konrad Michalski (dkm2@hi.is)
- Egill Hrafn Ólafsson (eho10@hi.is)

## Design Patterns Used

### Observer Pattern

- The `LibrarySystem` class acts as the Subject.
- The `LibraryObserver` interface defines the Observer role.
- The `LibraryStatistics` class is a concrete Observer that tracks borrowing statistics.

### Composite Pattern

- The `Omnibus` class represents a collection of books treated as a single entity.
- When operations are performed on an Omnibus, they are delegated to each individual book.

## Project Structure

For detailed UML diagrams and design documentation, see the [docs/Design.md](docs/Design.md) file.

The UML class diagram is available in [UML/library_system.uxf](UML/library_system.uxf) _TODO: OLD DIAGRAM_

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Building the Project

To build the project, use Maven:

```bash
mvn clean package
```

Or run the provided build script:

```
build.bat
```

### Running the Application

To run the application, use:

```bash
java -jar target/LibrarySystem-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Or use the provided run script:

```
run.bat
```

### Testing the Application

To run the tests, use:

```bash
mvn test
```

The tests cover the core functionality of the library system, including:

- Adding and finding books and users
- Borrowing and returning books
- Extending lending periods
- Omnibus functionality
- Observer pattern implementation

## Maven Goals

This project supports the following Maven goals:

- `mvn compile` - Compiles the source code
- `mvn test` - Runs the unit tests
- `mvn exec:java` - Executes the main class
- `mvn package` - Packages the application into a JAR file
- `mvn site` - Generates the project site documentation

## Documentation

To generate the project documentation, run:

```bash
mvn site
```

This will generate documentation in the `target/site` directory, including:

- Javadoc API documentation
- Test reports
- Project information
- UML diagrams and design documentation

## License

This project is licensed under the MIT License - see the LICENSE file for details.
