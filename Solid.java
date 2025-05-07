// File location: project/src/demo/Solid.java
package demo;

// S — Single Responsibility Principle
class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getDetails() {
        return title + " by " + author + ", Pages: " + pages;
    }
}

// SRP: Separate class responsible for printing
class BookPrinter {
    public void print(Book book) {
        System.out.println("Printing Book Details:");
        System.out.println(book.getDetails());
    }
}

// O — Open/Closed Principle
interface AreaCalculator {
    double calculateArea();
}

class Rectangle implements AreaCalculator {
    private double length, width;

    public Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public double calculateArea() {
        return length * width;
    }
}

class Circle implements AreaCalculator {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// L — Liskov Substitution Principle
class Bird {
    public void makeSound() {
        System.out.println("Bird chirps");
    }
}

class Parrot extends Bird {
    @Override
    public void makeSound() {
        System.out.println("Parrot talks");
    }
}

// I — Interface Segregation Principle
interface Printer {
    void print();
}

interface Fax {
    void fax();
}

class OfficePrinter implements Printer, Fax {
    public void print() {
        System.out.println("Printing document...");
    }

    public void fax() {
        System.out.println("Faxing document...");
    }
}

// D — Dependency Inversion Principle
interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class NotificationSender {
    private NotificationService service;

    public NotificationSender(NotificationService service) {
        this.service = service;
    }

    public void notifyUser(String message) {
        service.send(message);
    }
}

// Main class demonstrating all principles
public class Solid {
    public static void main(String[] args) {
        // SRP
        Book book = new Book("Effective Java", "Joshua Bloch", 416);
        BookPrinter printer = new BookPrinter();
        printer.print(book);

        // OCP
        AreaCalculator rectangle = new Rectangle(5, 4);
        AreaCalculator circle = new Circle(3);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Circle Area: " + circle.calculateArea());

        // LSP
        Bird bird = new Parrot();
        bird.makeSound();

        // ISP
        OfficePrinter officePrinter = new OfficePrinter();
        officePrinter.print();
        officePrinter.fax();

        // DIP
        NotificationService email = new EmailNotification();
        NotificationSender sender = new NotificationSender(email);
        sender.notifyUser("Your book order has been shipped.");
    }
}
