package com.commons.studio.controller;

import com.commons.studio.model.Book;
import com.commons.studio.service.book.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookServiceImpl bookService;

    @Test
    void getAlLBookings() throws Exception {
        //given
        List<Book> bookings = new ArrayList<>();
        Book book1 = new Book (1,
                "Joe Doe",
                LocalDate.of(2022,11,
                        16));

        Book book2 = new Book (2,
                "Carl Johnson",
                LocalDate.of(2022,11,
                        18));

        bookings.add(book1);
        bookings.add(book2);
        //when
        when(bookService.getAllBookings()).thenReturn(bookings);
        mvc.perform(get("/bookings").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].personName").value("Joe Doe"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].bookDate").value("2022-11-16"))
                .andExpect(jsonPath("$[1].personName").value("Carl Johnson"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].bookDate").value("2022-11-18"))
                .andExpect(jsonPath("$",hasSize(2)));
    }

    @Test
    void createStudioClass() throws Exception {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        Book book = new Book (1,
                "Joe Doe",
                LocalDate.of(2022,11,
                        16));

        //when
        mvc.perform(post("/bookings").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(content().string("New booking created"));
    }

    @Test
    void itShouldReturnValidationErrorWhenNameIsEmpty() throws Exception {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        Book book = new Book (1,
                "",
                LocalDate.of(2022,11,
                        16));

        //when
        mvc.perform(post("/bookings").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message").value("Validation Failed"));
    }

    @Test
    void itShouldReturnValidationErrorWhenNameHasWhiteSpaces() throws Exception {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        Book book = new Book (1,
                " ",
                LocalDate.of(2022,11,
                        16));

        //when
        mvc.perform(post("/bookings").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message").value("Validation Failed"))
                .andExpect(jsonPath("details.[0]").value("personName must not have white spaces"));
    }
}