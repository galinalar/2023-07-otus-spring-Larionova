package spring10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import spring10.dto.BookDto;
import spring10.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;

    @GetMapping("/api/books/")
    public List<BookDto> listBooks() {
        return bookService.getAll();
    }

    @GetMapping("/api/books/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("/api/books/{id}")
    public BookDto updateBook(@RequestBody BookDto book) {
        bookService.updateBook(book.getId(), book.getName(), book.getAuthor(), book.getGenre());
        return bookService.getBookById(book.getId());
    }

    @PostMapping("/api/books/")
    public void saveNewBook(@RequestBody BookDto book) {
        bookService.saveBook(book.getName(), book.getAuthor(), book.getGenre());
    }
}
