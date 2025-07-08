package service;

import dto.BookRequest;
import entity.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> removeOutdatedBooks(int maxAgeInYears);

    double buyBook(BookRequest bookRequest);

    List<Book> getAllBooks();

}
