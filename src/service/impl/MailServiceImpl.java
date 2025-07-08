package service.impl;

import dto.BookRequest;
import service.MailService;

public class MailServiceImpl implements MailService {

    @Override
    public void send(BookRequest bookRequest) {
        String message = "Book with ISBN: " + bookRequest.isbn() + " is send to email: " + bookRequest.email();
        System.out.println(message);
    }
}
