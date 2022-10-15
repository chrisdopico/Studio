package com.commons.studio.service.book;

import com.commons.studio.dao.book.IBookDAO;
import com.commons.studio.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class BookServiceImpl implements IBookService{

    @Autowired
    IBookDAO bookDAO;

    @Override
    public List<Book> getAllBookings() {
        return bookDAO.getAllBookings();
    }

    @Override
    public void createBooking(Book book) {
        bookDAO.createBooking(book);
    }
}
