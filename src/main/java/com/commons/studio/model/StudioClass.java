package com.commons.studio.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "t_classes")
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class StudioClass {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cla")
    private Integer id;

    @NotEmpty(message = "name must not be empty")
    @NotBlank(message = "name must not be white spaces")
    @Column(name = "cla_nam")
    private String name;

    @NotNull(message = "startDate must not be empty")
    @Column(name = "sta_dat",unique = true)
    private LocalDate startDate;

    @NotNull(message = "endDate must not be empty")
    @Column(name = "end_date", unique = true)
    private LocalDate endDate;

    @Positive(message = "capacity must be an integer greater than 0")
    @NotNull(message = "capacity must not be null")
    @Column(name = "cap")
    private Integer capacity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudioClass)) return false;
        StudioClass studioClass = (StudioClass) o;
        return Objects.equals(id,studioClass.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
