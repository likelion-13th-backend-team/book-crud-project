package com.springboot.crud_project.dao.Impl;


import com.springboot.crud_project.dao.BookDao;
import com.springboot.crud_project.dto.ChangeTitleRequestDto;
import com.springboot.crud_project.dto.RequestDto;
import com.springboot.crud_project.dto.ResponseDto;
import com.springboot.crud_project.entity.Book;
import com.springboot.crud_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;

    @Autowired
    public BookDaoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseDto saveBook(RequestDto requestDto) {
        Book book = new Book();
        book.setTitle(requestDto.getTitle());
        book.setAuthor(requestDto.getAuthor());
        book.setPublisher(requestDto.getPublisher());
        book.setCategory(requestDto.getCategory());

        Book savedBook = bookRepository.save(book);
        return convertToResponseDto(savedBook);
    }

    @Override
    public List<ResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResponseDto> getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::convertToResponseDto);
    }

    @Override
    public Optional<ResponseDto> getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author)
                .map(this::convertToResponseDto);
    }

    @Override
    public ResponseDto updateBookTitle(ChangeTitleRequestDto changeTitleRequestDto) {
        Optional<Book> bookOptional = bookRepository.findByAuthor(changeTitleRequestDto.getAuthor());
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(changeTitleRequestDto.getTitle());
            Book updatedBook = bookRepository.save(book);
            return convertToResponseDto(updatedBook);
        } else {
            throw new RuntimeException("Book with author " + changeTitleRequestDto.getAuthor() + " not found");
        }
    }

    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ResponseDto convertToResponseDto(Book book) {
        return new ResponseDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getCategory()
        );
    }
}