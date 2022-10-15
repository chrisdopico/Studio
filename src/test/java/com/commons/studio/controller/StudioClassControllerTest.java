package com.commons.studio.controller;


import com.commons.studio.model.StudioClass;
import com.commons.studio.service.studioclass.StudioClassServiceImpl;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudioClassController.class)
class StudioClassControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudioClassServiceImpl studioClassService;

    @Test
    void getAlLStudioClasses() throws Exception {
        //given
        List<StudioClass> classes = new ArrayList<>();
        StudioClass studioClass1 = new StudioClass (1,
                "Pilates",
                LocalDate.of(2022,12,16),
                LocalDate.of(2022,12,18),
                20);

        StudioClass studioClass2 = new StudioClass (2,
                "Yoga",
                LocalDate.of(2022,11,16),
                LocalDate.of(2022,11,18),
                15);

        classes.add(studioClass1);
        classes.add(studioClass2);
        //when
        when(studioClassService.getAlLStudioClasses()).thenReturn(classes);
        mvc.perform(get("/classes").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Pilates"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].startDate").value("2022-12-16"))
                .andExpect(jsonPath("$[0].endDate").value("2022-12-18"))
                .andExpect(jsonPath("$[0].capacity").value(20))
                .andExpect(jsonPath("$[1].name").value("Yoga"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].startDate").value("2022-11-16"))
                .andExpect(jsonPath("$[1].endDate").value("2022-11-18"))
                .andExpect(jsonPath("$[1].capacity").value(15))
                .andExpect(jsonPath("$",hasSize(2)));

        //then
        verify(studioClassService).getAlLStudioClasses();
    }


    @Test
    void createStudioClass() throws Exception {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        StudioClass studioClass = new StudioClass(2,
                "Yoga",
                LocalDate.of(2022,11,16),
                LocalDate.of(2022,11,18),
                15);

        //when
        mvc.perform(post("/classes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(studioClass)))
                .andExpect(status().isCreated())
                .andExpect(content().string("New class created"));
    }
}