package com.commons.studio.dao.studioclass;

import com.commons.studio.model.StudioClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudioClassDaoImplTest {

    @Autowired
    StudioClassDaoImpl underTest;
    @Autowired
    IStudioClassJPA studioClassJPA;

    @Test
    void itShouldCheckIfGetAlLStudioClasses() {
        //given
        StudioClass studioClass1 = new StudioClass(5,
                "Joe Johnson",
                LocalDate.of(2022,12,13),
                LocalDate.of(2022,12,15),
                20);

        StudioClass studioClass2 = new StudioClass(6,
                "Carl Dempsey",
                LocalDate.of(2023,12,15),
                LocalDate.of(2023,12,17),
                10);

        underTest.createStudioClass(studioClass1);
        underTest.createStudioClass(studioClass2);
        //when
        Integer expected = underTest.getAlLStudioClasses().size();
        //then
        assertThat(expected).isEqualTo(6);
    }


    @Test
    void itShouldCreateAStudioClass() {
        //given
        StudioClass studioClass1 = new StudioClass(5,
                "Joe Johnson",
                LocalDate.of(2022,12,13),
                LocalDate.of(2022,12,15),
                20);
        underTest.createStudioClass(studioClass1);
        //when
        Optional<StudioClass> expected = studioClassJPA.findById(5);
        //then
        assertThat(expected.isPresent()).isTrue();
    }

}