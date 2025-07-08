package test;

import dto.BookRequest;
import entity.Book;
import entity.PaperBook;
import enums.BookType;
import exception.handler.GlobalExceptionHandler;
import service.BookService;
import service.MailService;
import service.ShippingService;
import service.impl.BookServiceImpl;
import service.impl.MailServiceImpl;
import service.impl.ShippingServiceImpl;
import util.BookInitializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookStoreTest {

    private static Map<String, Book> books = BookInitializer.initBooks();
    private static ShippingService shippingService = new ShippingServiceImpl();
    private static MailService mailService = new MailServiceImpl();
    private static BookService bookService = new BookServiceImpl(new ArrayList<>(books.values()), shippingService, mailService);

    public static void run() {
        System.out.println(" ** Testing Book Store ** ");
        System.out.println("-".repeat(60));

        System.out.println("Test Happy Scenario");
        System.out.println("-".repeat(60));

        showInventoryTest();
        addBookTest();
        System.out.println("Inventory after adding new book");
        showInventoryTest();

        removeOutdatedBooksTest();
        System.out.println("Inventory after removing outdated books");
        showInventoryTest();

        buyingPaperBookTest();
        buyingEBookTest();
        buyingDemoBookTest();

        System.out.println("Inventory after deducting requiredQuantity for paper book");
        showInventoryTest();

        System.out.println("\nTest Bad Scenario");
        System.out.println("-".repeat(60));

        addDuplicatedBookTest();
        showInventoryTest();

        buyingPaperBookWithInsufficientQuantityTest();

        buyingNotFoundPaperBookTest();

    }

    //              Happy Scenario
    private static void showInventoryTest() {
        System.out.println("Inventory:");
        bookService.getAllBooks().forEach(System.out::println);
        System.out.println("-".repeat(60));
    }

    private static void addBookTest() {
        System.out.println("Test#1: Adding Book");
        bookService.addBook(
                new PaperBook("981", "Spring Security in Action", 575.0, BookType.PAPER_BOOK, LocalDate.of(2020, 1, 27), 10)
        );
        System.out.println("-".repeat(60));
    }

    private static void removeOutdatedBooksTest() {
        System.out.println("Test#2: Remove Outdated books after 'maxAgeInYears=10' years");
        List<Book> outdatedBooks = bookService.removeOutdatedBooks(10);
        System.out.println("Outdated Books that removed: ");
        outdatedBooks.forEach(System.out::println);
        System.out.println("-".repeat(60));
    }

    private static void buyingPaperBookTest() {
        System.out.println("Test#3: Buying PaperBook with 'requiredQuantity=4'");
        double paidAmount = bookService.buyBook(new BookRequest(
                "977", 4, "mahmoud404@gmail.com", "6th of october city, Giza")
        );
        System.out.println("Amount Paid: " + paidAmount);
        System.out.println("-".repeat(60));
    }

    private static void buyingEBookTest() {
        System.out.println("Test#4: Buying EBook");
        double paidAmount = bookService.buyBook(new BookRequest(
                "978", 0, "mahmoud404@gmail.com", "6th of october city, Giza")
        );
        System.out.println("Amount Paid: " + paidAmount);
        System.out.println("-".repeat(60));
    }

    private static void buyingDemoBookTest() {
        System.out.println("Test#5: Trying Buy DemoBook");
        bookService.buyBook(new BookRequest(
                "979", 4, "mahmoud404@gmail.com", "6th of october city, Giza")
        );
        System.out.println("-".repeat(60));
    }

    //----------------------------------------------------------------------------
    //              Bad Scenario

    private static void addDuplicatedBookTest() {
        System.out.println("Test#1: Adding Duplicated Book");
        try {
            bookService.addBook(
                    new PaperBook("981", "Spring Security in Action", 575.0, BookType.PAPER_BOOK, LocalDate.of(2020, 1, 27), 10)
            );
        } catch (Exception e) {
            GlobalExceptionHandler.handle(e);
        }
        System.out.println("-".repeat(60));
    }

    private static void buyingPaperBookWithInsufficientQuantityTest() {
        System.out.println("Test#2: Buying PaperBook with 'requiredQuantity=15'");
        try {
            bookService.buyBook(new BookRequest(
                    "977", 15, "mahmoud404@gmail.com", "6th of october city, Giza")
            );
        } catch (Exception e) {
            GlobalExceptionHandler.handle(e);
        }
        System.out.println("-".repeat(60));
    }

    private static void buyingNotFoundPaperBookTest() {
        System.out.println("Test#3: Buying PaperBook Not Found");
        try {


            bookService.buyBook(new BookRequest(
                    "999", 1, "mahmoud404@gmail.com", "6th of october city, Giza")
            );
        } catch (Exception e) {
            GlobalExceptionHandler.handle(e);
        }
        System.out.println("-".repeat(60));
    }

}
