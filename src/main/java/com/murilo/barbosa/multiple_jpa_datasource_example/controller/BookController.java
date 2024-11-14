package com.murilo.barbosa.multiple_jpa_datasource_example.controller;

import com.murilo.barbosa.multiple_jpa_datasource_example.dto.BookDto;
import com.murilo.barbosa.multiple_jpa_datasource_example.mysql.domain.BookMySql;
import com.murilo.barbosa.multiple_jpa_datasource_example.mysql.repository.BookMysqlRepository;
import com.murilo.barbosa.multiple_jpa_datasource_example.postgres.domain.BookPostgres;
import com.murilo.barbosa.multiple_jpa_datasource_example.postgres.repository.BookPostgresRepository;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookPostgresRepository bookPostgresRepository;
    private final BookMysqlRepository bookMysqlRepository;

    @PostMapping
    public ResponseEntity<List<BookDto>> createBook(@RequestBody BookDto bookDto) {
        var book1 = bookPostgresRepository.save(new BookPostgres(bookDto));
        var book2 = bookMysqlRepository.save(new BookMySql(bookDto));
        return ResponseEntity.ok(List.of(new BookDto(book1), new BookDto(book2)));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        var books1 = bookPostgresRepository.findAll().stream().map(BookDto::new).toList();
        var books2 = bookMysqlRepository.findAll().stream().map(BookDto::new).toList();
        return ResponseEntity.ok(Stream.concat(books1.stream(), books2.stream()).toList());
    }
}
