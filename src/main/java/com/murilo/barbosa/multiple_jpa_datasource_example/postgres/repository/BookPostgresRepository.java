package com.murilo.barbosa.multiple_jpa_datasource_example.postgres.repository;

import com.murilo.barbosa.multiple_jpa_datasource_example.postgres.domain.BookPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPostgresRepository extends JpaRepository<BookPostgres, Long> {

}
