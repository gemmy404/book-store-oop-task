package entity;

import enums.BookType;

import java.time.LocalDate;

public class EBook extends Book{

    private String fileType;

    public EBook(String isbn, String title, double price, BookType bookType, LocalDate publishDate, String fileType) {
        super(isbn, title, price, bookType, publishDate);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", bookType=" + bookType +
                ", publishDate=" + publishDate +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
