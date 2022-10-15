package com.commons.studio.dao.book;

import com.commons.studio.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BookDaoImplTest {

    @Autowired
    BookDaoImpl underTest;
    @Autowired
    IBookJPA bookJPA;

    @Test
    void itShouldCheckIfGetAlLBookings() {
        //given
        Book book1 = new Book(4,
                "Daniel",
                LocalDate.of(2022,12,13));
        Book book2 = new Book(5,
                "Daniel",
                LocalDate.of(2022,12,16));

        underTest.createBooking(book1);
        underTest.createBooking(book2);
        //when
        Integer expected = underTest.getAllBookings().size();
        //then
        assertThat(expected).isEqualTo(5);
    }


    @Test
    void itShouldCreateABooking() {
        //given
        Book book1 = new Book(4,
                "Daniel",
                LocalDate.of(2022,12,13));
        underTest.createBooking(book1);
        //when
        Optional<Book> expected = bookJPA.findById(4);
        //then
        assertThat(expected.isPresent()).isTrue();
    }
}