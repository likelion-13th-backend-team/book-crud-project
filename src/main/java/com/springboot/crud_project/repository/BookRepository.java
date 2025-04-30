package com.springboot.crud_project.repository;

import com.springboot.crud_project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByAuthor(String author);
    boolean existsByAuthor(String author);
}