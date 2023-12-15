package spring11.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring11.domain.Book;
import spring11.dto.BookDto;

public interface BookService {

    Flux<BookDto> getAll();

    Mono<BookDto> getBookById(Long id);

    Mono<Book> getBookDomainById(Long id);

    Mono<BookDto> saveBook(BookDto bookDto);

    Mono<BookDto> updateBook(BookDto bookDto);

    Mono<Void> deleteBookById(Long id);
}
