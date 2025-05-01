package com.springboot.crud_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Book {

    // Setter 메서드
    // Getter 메서드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String author;

    @Column
    private String publisher;

    @Column
    private String category;

    // 기본 생성자
    public Book() {
    }

    // 모든 필드를 인자로 받는 생성자
    public Book(Long id, String title, String author, String publisher, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book(id=" + id + ", title=" + title + ", author=" + author +
                ", publisher=" + publisher + ", category=" + category + ")";
    }
}