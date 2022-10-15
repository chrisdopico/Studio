package com.commons.studio.service.book;

import com.commons.studio.dao.book.IBookDAO;
import com.commons.studio.dao.studioclass.IStudioClassDAO;
import com.commons.studio.model.Book;
import com.commons.studio.model.StudioClass;
import com.commons.studio.service.studioclass.StudioClassServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private IBookDAO bookDAO;
    private BookServiceImpl underTest;

    @BeforeEach
    void setup(){
        underTest = new BookServiceImpl(bookDAO);
    }

    @Test
    void getAllBookings() {
        //when
        underTest.getAllBookings();

        //then
        verify(bookDAO).getAllBookings();
    }

    @Test
    void createBooking() {
        //given
        Book book = new Book(4,
                "Daniel",
                LocalDate.of(2022,12,13));
        //when
        underTest.createBooking(book);

        //then
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.
                forClass(Book.class);

        verify(bookDAO).createBooking(bookArgumentCaptor.capture());
        Book capturedBookClass = bookArgumentCaptor.getValue();

        assertThat(capturedBookClass).isEqualTo(book);
    }
}