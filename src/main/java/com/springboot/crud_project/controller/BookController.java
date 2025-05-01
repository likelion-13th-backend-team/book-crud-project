package com.springboot.crud_project.controller;

import com.springboot.crud_project.dto.ChangeTitleRequestDto;
import com.springboot.crud_project.dto.RequestDto;
import com.springboot.crud_project.dto.ResponseDto;
import com.springboot.crud_project.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@Tag(name = "Book API", description = "도서 관리 기능 API (등록, 조회, 수정, 삭제)")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "도서 등록", description = "새로운 도서를 등록합니다.")
    @PostMapping
    public ResponseEntity<ResponseDto> addBook(@RequestBody RequestDto requestDto) {
        ResponseDto savedBook = bookService.addBook(requestDto);
        return ResponseEntity.ok(savedBook);
    }

    @Operation(summary = "전체 도서 조회", description = "등록된 모든 도서를 조회합니다.")
    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllBooks() {
        List<ResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @Operation(summary = "도서 ID 조회", description = "도서 ID로 특정 도서를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getBookById(@PathVariable Long id) {
        Optional<ResponseDto> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "저자명으로 도서 조회", description = "저자명으로 도서를 조회합니다. (주의: 한 명의 저자만 조회 가능)")
    @GetMapping("/author/{author}")
    public ResponseEntity<ResponseDto> getBookByAuthor(@PathVariable String author) {
        Optional<ResponseDto> book = bookService.getBookByAuthor(author);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "도서 제목 수정", description = "저자명을 기준으로 도서 제목을 수정합니다.")
    @PutMapping("/title")
    public ResponseEntity<ResponseDto> updateBookTitle(@RequestBody ChangeTitleRequestDto changeTitleRequestDto) {
        try {
            ResponseDto updatedBook = bookService.updateBookTitle(changeTitleRequestDto);
            return ResponseEntity.ok(updatedBook);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "도서 삭제", description = "도서 ID를 기준으로 도서를 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}