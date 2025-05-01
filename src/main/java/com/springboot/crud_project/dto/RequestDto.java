package com.springboot.crud_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private String title;
    private String author;
    private String publisher;
    private String category;

    public String toString(){
        return "RequestDto(title=" + this.title + ", author=" + this.author + ", publisher=" + this.publisher + ", category=" + this.category +")";
    }
}
