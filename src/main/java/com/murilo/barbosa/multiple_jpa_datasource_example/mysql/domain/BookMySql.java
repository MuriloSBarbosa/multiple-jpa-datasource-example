package com.murilo.barbosa.multiple_jpa_datasource_example.mysql.domain;

import com.murilo.barbosa.multiple_jpa_datasource_example.dto.BookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookMySql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    public BookMySql(BookDto bookDto) {
        this(bookDto.id(), bookDto.title(), bookDto.author());
    }
}
