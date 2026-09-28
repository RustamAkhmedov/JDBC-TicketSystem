# JDBC-TicketSystem

A simple ticket web app built with Spring MVC, Thymeleaf and plain JDBC (`JdbcTemplate`) on PostgreSQL.

## Features

- `/tickets` lists all tickets
- `/add` shows a form for creating a new ticket (message, date, description) with validation

## Tech

Java · Spring Web MVC 5.3 · Spring JDBC · Thymeleaf · PostgreSQL · Maven (WAR)

## Setup

1. Create the database and table:

   ```sql
   CREATE DATABASE ticket;
   \c ticket
   CREATE TABLE tickets (
       id          INT PRIMARY KEY,
       message     TEXT NOT NULL,
       date        TEXT NOT NULL,
       description TEXT NOT NULL
   );
   ```

2. Adjust the connection details in `src/main/resources/database.properties`.
3. Build the WAR and deploy it to a servlet container such as Tomcat 9:

   ```bash
   mvn package
   ```

4. Open `http://localhost:8080/<context>/tickets`.
