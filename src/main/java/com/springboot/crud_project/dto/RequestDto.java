package com.springboot.crud_project.dto;

public class RequestDto {
    private String title;
    private String author;
    private String publisher;
    private String category;

    public RequestDto() {
    }

    public RequestDto(String title, String author, String publisher, String category) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString(){
        return "RequestDto(title=" + this.title + ", author=" + this.author + ", publisher=" + this.publisher + ", category=" + this.category +")";
    }
}