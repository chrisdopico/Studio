package com.commons.studio.dao.book;

import com.commons.studio.model.Book;


import java.util.List;

public interface IBookDAO {
    List<Book> getAllBookings();
    void createBooking(Book book);
}
