package entity;

import enums.BookType;

import java.time.LocalDate;

public class DemoBook extends Book{


    public DemoBook(String isbn, String title, double price, BookType bookType, LocalDate publishDate) {
        super(isbn, title, price, bookType, publishDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", bookType=" + bookType +
                ", publishDate=" + publishDate +
                '}';
    }
}
