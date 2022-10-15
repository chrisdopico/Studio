package com.commons.studio.controller;

import com.commons.studio.model.Book;
import com.commons.studio.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/bookings")
    public List<Book> getAlLBookings(){
        return bookService.getAllBookings();
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> createStudioClass(@Valid @RequestBody Book book){
        try {
            bookService.createBooking(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("New booking created");
        }catch (ConstraintViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date");
        }

    }
}
