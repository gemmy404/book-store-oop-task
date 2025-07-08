package service;

import dto.BookRequest;

public interface ShippingService {

    void send(BookRequest bookRequest);

}
