package service.impl;

import dto.BookRequest;
import entity.Book;
import entity.PaperBook;
import enums.BookType;
import exception.BookNotFoundException;
import exception.DuplicateBookException;
import exception.InsufficientQuantityException;
import service.BookService;
import service.MailService;
import service.ShippingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private List<Book> books;
    private ShippingService shippingService;
    private MailService mailService;

    public BookServiceImpl(List<Book> books, ShippingService shippingService, MailService mailService) {
        this.books = books;
        this.shippingService = shippingService;
        this.mailService = mailService;
    }

    @Override
    public void addBook(Book book) {
        Optional<Book> savedBook = books.stream()
                .filter(b -> b.getIsbn().equals(book.getIsbn()))
                .findFirst();
        if (savedBook.isPresent()) {
            throw new DuplicateBookException("Book already with ISBN: " + book.getIsbn() + " exists");
        }

        books.add(book);

        String message = "Book with ISBN: " + book.getIsbn() + " added successfully";
        System.out.println(message);

    }

    @Override
    public List<Book> removeOutdatedBooks(int maxAgeInYears) {
        List<Book> outdatedBooks = books.stream()
                .filter(book -> book.getPublishDate().getYear() + maxAgeInYears < LocalDate.now().getYear())
                .toList();

        books.removeAll(outdatedBooks);

        String message = "Outdated books removed successfully";
        System.out.println(message);

        return outdatedBooks;
    }

    @Override
    public double buyBook(BookRequest bookRequest) {
        Book savedBook = books.stream()
                .filter(b -> b.getIsbn().equals(bookRequest.isbn())).findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with ISBN: " + bookRequest.isbn() + " not found"));

        int requiredQuantity;

        if (savedBook.getBookType().equals(BookType.PAPER_BOOK)) {
            PaperBook paperBook = (PaperBook) savedBook;
            if (paperBook.getStockQuantity() >= bookRequest.requiredQuantity()) {
                paperBook.setStockQuantity(paperBook.getStockQuantity() - bookRequest.requiredQuantity());
                requiredQuantity = bookRequest.requiredQuantity();
                shippingService.send(bookRequest);
            } else {
                throw new InsufficientQuantityException("Insufficient quantity for book with ISBN: " + bookRequest.isbn());
            }
        } else if (savedBook.getBookType().equals(BookType.EBOOK)) {
            requiredQuantity = 1;
            mailService.send(bookRequest);
        } else {
            String message = "Book with ISBN: " + bookRequest.isbn() + " is DemoBook, can't be purchased";
            System.out.println(message);
            return 0.0;
        }

        return savedBook.getPrice() * requiredQuantity;
    }

    @Override
    public List<Book> getAllBooks() {
        if (!books.isEmpty()) {
            return books;
        }
        throw new BookNotFoundException("No books found");
    }
}
