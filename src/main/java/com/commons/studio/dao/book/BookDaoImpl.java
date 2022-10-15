package com.commons.studio.dao.book;

import com.commons.studio.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class BookDaoImpl implements IBookDAO{

    @Autowired
    IBookJPA bookJPA;

    @Override
    public List<Book> getAllBookings() {
        return bookJPA.findAll();
    }

    @Override
    public void createBooking(Book book) {
        bookJPA.save(book);
    }
}
