package com.murilo.barbosa.multiple_jpa_datasource_example.dto;

import com.murilo.barbosa.multiple_jpa_datasource_example.mysql.domain.BookMySql;
import com.murilo.barbosa.multiple_jpa_datasource_example.postgres.domain.BookPostgres;
import lombok.Builder;

@Builder
public record BookDto(
      Long id,
      String title,
      String author,
      String type
) {

    public BookDto(BookMySql bookMySql) {
        this(bookMySql.getId(), bookMySql.getTitle(), bookMySql.getAuthor(), "mysql");
    }

    public BookDto(BookPostgres bookPostgres) {
        this(bookPostgres.getId(), bookPostgres.getTitle(), bookPostgres.getAuthor(), "postgres");
    }
}
