package com.springboot.crud_project.service.Impl;

import com.springboot.crud_project.dao.BookDao;
import com.springboot.crud_project.dto.ChangeTitleRequestDto;
import com.springboot.crud_project.dto.RequestDto;
import com.springboot.crud_project.dto.ResponseDto;
import com.springboot.crud_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public ResponseDto addBook(RequestDto requestDto) {
        return bookDao.saveBook(requestDto);
    }

    @Override
    public List<ResponseDto> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Optional<ResponseDto> getBookById(Long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public Optional<ResponseDto> getBookByAuthor(String author) {
        return bookDao.getBookByAuthor(author);
    }

    @Override
    public ResponseDto updateBookTitle(ChangeTitleRequestDto changeTitleRequestDto) {
        return bookDao.updateBookTitle(changeTitleRequestDto);
    }

    @Override
    public boolean deleteBook(Long id) {
        return bookDao.deleteBook(id);
    }
}