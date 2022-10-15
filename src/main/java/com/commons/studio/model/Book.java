package com.commons.studio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "t_bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_boo")
    private Integer id;

    @NotEmpty(message = "personName must not be empty")
    @NotBlank(message = "personName must not be white spaces")
    @Column(name = "per_nam")
    private String personName;

    @NotNull(message = "bookDate must not be empty")
    @Column(name = "boo_date")
    private LocalDate bookDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id,book.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
