package com.commons.studio.dao.book;

import com.commons.studio.dao.studioclass.IStudioClassJPA;
import com.commons.studio.model.Book;
import com.commons.studio.model.StudioClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class IBookJPATest {

    @Autowired
    IBookJPA underTest;

    @Test
    void itShouldCheckIfGetAlLBookings() {
        //given
        Book book1 = new Book(4,
                "Daniel",
                LocalDate.of(2022,12,13));
        Book book2 = new Book(5,
                "Daniel",
                LocalDate.of(2022,12,16));

        underTest.save(book1);
        underTest.save(book2);
        //when
        Integer expected = underTest.findAll().size();
        //then
        assertThat(expected).isEqualTo(5);
    }


    @Test
    void itShouldCreateABooking() {
        //given
        Book book1 = new Book(4,
                "Daniel",
                LocalDate.of(2022,12,13));
        underTest.save(book1);
        //when
        Optional<Book> expected = underTest.findById(4);
        //then
        assertThat(expected.isPresent()).isTrue();
    }

}