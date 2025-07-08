package service;

import dto.BookRequest;

public interface MailService {

    void send(BookRequest bookRequest);
}
