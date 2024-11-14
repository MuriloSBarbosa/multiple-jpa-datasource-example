package com.murilo.barbosa.multiple_jpa_datasource_example.mysql.repository;

import com.murilo.barbosa.multiple_jpa_datasource_example.mysql.domain.BookMySql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMysqlRepository extends JpaRepository<BookMySql, Integer> {

}
