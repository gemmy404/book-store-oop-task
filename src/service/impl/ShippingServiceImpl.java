package service.impl;

import dto.BookRequest;
import service.ShippingService;

public class ShippingServiceImpl implements ShippingService {

    @Override
    public void send(BookRequest bookRequest) {
        String message = "Book with ISBN: " + bookRequest.isbn() + " is shipped to address: " + bookRequest.address();
        System.out.println(message);
    }
}
