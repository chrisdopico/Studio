package com.commons.studio.service.book;

import com.commons.studio.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBookings();
    void createBooking(Book book);
}
