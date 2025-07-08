package entity;

import enums.BookType;

import java.time.LocalDate;

public class PaperBook extends Book{

    private int stockQuantity;

    public PaperBook(String isbn, String title, double price, BookType bookType, LocalDate publishDate, int stockQuantity) {
        super(isbn, title, price, bookType, publishDate);
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", bookType=" + bookType +
                ", publishDate=" + publishDate +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
