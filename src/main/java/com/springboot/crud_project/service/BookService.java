package com.springboot.crud_project.service;

import com.springboot.crud_project.dto.ChangeTitleRequestDto;
import com.springboot.crud_project.dto.RequestDto;
import com.springboot.crud_project.dto.ResponseDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    ResponseDto addBook(RequestDto requestDto);
    List<ResponseDto> getAllBooks();
    Optional<ResponseDto> getBookById(Long id);
    Optional<ResponseDto> getBookByAuthor(String author);
    ResponseDto updateBookTitle(ChangeTitleRequestDto changeTitleRequestDto);
    boolean deleteBook(Long id);
}