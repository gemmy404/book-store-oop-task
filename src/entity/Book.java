package entity;

import enums.BookType;

import java.time.LocalDate;

public class Book {

    protected String isbn;
    protected String title;
    protected double price;
    protected BookType bookType;
    protected LocalDate publishDate;


    public Book() {
    }

    public Book(String isbn, String title, double price, BookType bookType, LocalDate publishDate) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.bookType = bookType;
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
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
