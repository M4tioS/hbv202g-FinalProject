# UML Diagrams

## Class Diagram

The class diagram for the Library System is available in multiple formats:

- [UMLet format (library_system.uxf)](UML/library_system.uxf)
- [PNG image format (hbv202gFinalAssignment1.drawio.png)](UML/hbv202gFinalAssignment1.drawio.png)
- [PDF format (hbv202gFinalAssignment1.drawio.pdf)](<UML/hbv202gFinalAssignment1.drawio%20(1).pdf>)

![Class Diagram](UML/hbv202gFinalAssignment1.drawio.png)

## Design Patterns

This project implements the following design patterns:

### Observer Pattern

The Observer pattern is implemented with:

- `LibrarySystem` as the Subject
- `LibraryObserver` as the Observer interface
- `LibraryStatistics` as a concrete Observer implementation

### Composite Pattern

The Composite pattern is implemented with:

- `Book` as the Component
- `Omnibus` as the Composite that contains multiple books
