# Multiple JPA Datasource Example 🗄️

This repository contains an example of a Spring Boot application with multiple JPA datasources using
MySQL and PostgreSQL.

## Configuration

| Name          | Description                                                     | Implementation                                                                                                         |
|:--------------|:----------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------|
| 🐘 PostgreSQL | Configuration for PostgreSQL datasource and JPA entity manager. | [PostgresConfig](./src/main/java/com/murilo/barbosa/multiple_jpa_datasource_example/configuration/PostgresConfig.java) |
| 🐬 MySQL      | Configuration for MySQL datasource and JPA entity manager.      | [MySqlConfig](./src/main/java/com/murilo/barbosa/multiple_jpa_datasource_example/configuration/MySqlConfig.java)       |

## Controllers

| Name              | Description                                                                | Implementation                                                                                                      |
|:------------------|:---------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------|
| 📚 BookController | REST controller for managing books in both MySQL and PostgreSQL databases. | [BookController](./src/main/java/com/murilo/barbosa/multiple_jpa_datasource_example/controller/BookController.java) |

## Repositories

| Name                      | Description                                               | Implementation                                                                                                                               |
|:--------------------------|:----------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------|
| 📚 BookPostgresRepository | JPA repository for managing books in PostgreSQL database. | [BookPostgresRepository](./src/main/java/com/murilo/barbosa/multiple_jpa_datasource_example/postgres/repository/BookPostgresRepository.java) |
| 📚 BookMysqlRepository    | JPA repository for managing books in MySQL database.      | [BookMysqlRepository](./src/main/java/com/murilo/barbosa/multiple_jpa_datasource_example/mysql/repository/BookMysqlRepository.java)          |

## Docker

- [docker-compose.yml](./docker-compose.yml): Docker Compose file to set up MySQL and PostgreSQL
  containers.

## Running the Application

1. Start the databases using Docker Compose:
   ```sh
   docker-compose up
   ```
2. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

## Endpoints

- `POST /books`: Create a new book in both MySQL and PostgreSQL databases.
- `GET /books`: Retrieve all books from both MySQL and PostgreSQL databases.