package com.commons.studio.service.studioclass;

import com.commons.studio.dao.studioclass.IStudioClassDAO;
import com.commons.studio.model.StudioClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import com.commons.studio.util.*;
@ExtendWith(MockitoExtension.class)
class StudioClassServiceImplTest {

    @Mock
    private IStudioClassDAO studioClassDAO;
    private StudioClassServiceImpl underTest;

    @BeforeEach
    void setup(){
        underTest = new StudioClassServiceImpl(studioClassDAO);
    }


    @Test
    void getAlLStudioClasses() {
        //when
        underTest.getAlLStudioClasses();

        //then
        verify(studioClassDAO).getAlLStudioClasses();
    }

    @Test
    void createStudioClass() {
        //given
        StudioClass studioClass = new StudioClass(5,
                "Joe Johnson",
                LocalDate.of(2022,12,13),
                LocalDate.of(2022,12,15),
                20);

        //when
        underTest.createStudioClass(studioClass);

        //then
        ArgumentCaptor<StudioClass> studioClassArgumentCaptor = ArgumentCaptor.
                forClass(StudioClass.class);

        verify(studioClassDAO).createStudioClass(studioClassArgumentCaptor.capture());
        StudioClass capturedStudioClass = studioClassArgumentCaptor.getValue();

        assertThat(capturedStudioClass).isEqualTo(studioClass);
    }

    @Disabled
    @Test()
    void willThrowErrorWhenNameIsEmpty(){
        //given
        StudioClass studioClass = new StudioClass(5,
                "",
                LocalDate.of(2022,12,13),
                LocalDate.of(2022,12,15),
                20);

        //when
        underTest.createStudioClass(studioClass);
    }
}