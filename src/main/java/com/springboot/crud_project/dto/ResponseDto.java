package com.springboot.crud_project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String category;

    // 기본 생성자
    public ResponseDto() {
    }

    // 모든 필드를 인자로 받는 생성자
    public ResponseDto(Long id, String title, String author, String publisher, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    public String toString(){
        return "ResponseDto(id=" + this.getId() + ", title=" + this.getTitle() + ", author=" + this.getAuthor() + ", publisher=" + this.getPublisher() + ", category=" + this.getCategory() +")";
    }
}