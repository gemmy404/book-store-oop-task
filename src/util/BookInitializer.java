package util;

import entity.Book;
import entity.DemoBook;
import entity.EBook;
import entity.PaperBook;
import enums.BookType;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class BookInitializer {

    public static Map<String, Book> initBooks() {
        Map<String, Book> books = new TreeMap<>();

        books.put(
                "977",
                new PaperBook("977", "Head First Java", 450.0, BookType.PAPER_BOOK, LocalDate.of(2017, 10, 16), 10)
        );
        books.put(
                "978",
                new EBook("978", "Spring in action", 500.0, BookType.EBOOK, LocalDate.of(2019, 5, 13), "PDF")
        );
        books.put(
                "979",
                new DemoBook("979", "Spring Boot in action", 0.0, BookType.DEMO_BOOK, LocalDate.of(2018, 7, 10))
        );
        books.put(
                "980",
                new PaperBook("980", "Efficient MySQL Performance", 375.0, BookType.PAPER_BOOK, LocalDate.of(2014, 1, 26), 3)
        );

        return books;
    }

}
