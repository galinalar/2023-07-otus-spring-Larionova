package spring11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring11.dto.BookDto;
import spring11.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;

    @GetMapping("/api/books/")
    public Flux<BookDto> listBooks() {
        return bookService.getAll();
    }

    @GetMapping("/api/books/{id}")
    public Mono<BookDto> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id).subscribe();
    }

    @PutMapping("/api/books/{id}")
    public Mono<BookDto> updateBook(@RequestBody BookDto book) {
        return bookService.updateBook(book);
    }

    @PostMapping("/api/books/")
    public Mono<BookDto> saveNewBook(@RequestBody BookDto book) {
        return bookService.saveBook(book);
    }
}
