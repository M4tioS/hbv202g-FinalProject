# Library Management System

A library management software system for the HBV202G final project. This software implements a library system with books, users (students and faculty members), and lending functionality.

## Features

- Add and search for books and users
- Borrow and return books
- Extend lending periods for faculty members
- Track lending statistics
- Support for omnibus (collections of books)

## Design Patterns

This project demonstrates two key design patterns:

### Observer Pattern

- The `LibrarySystem` class acts as the Subject
- The `LibraryObserver` interface defines the Observer role
- The `LibraryStatistics` class is a concrete Observer that tracks borrowing statistics

### Composite Pattern

- The `Omnibus` class represents a collection of books treated as a single entity
- When operations are performed on an Omnibus, they are delegated to each individual book

## Documentation

For more information, please see:

- [UML Diagrams](uml-diagrams.html) - Class diagram and design pattern representation
- [Design Documentation](design.html) - Detailed description of the system architecture and patterns
- [API Documentation](apidocs/index.html) - Javadoc for the codebase
- [Test Documentation](testapidocs/index.html) - Javadoc for the test code

## Getting Started

For detailed information on how to use the library system, please refer to the [Design Documentation](design.html) and the [API Documentation](apidocs/index.html).

## Project Structure

The project is organized according to Maven conventions:

- `src/main/java` - Source code
- `src/test/java` - Test code
- `docs` - Design documentation
- `UML` - UML diagrams
