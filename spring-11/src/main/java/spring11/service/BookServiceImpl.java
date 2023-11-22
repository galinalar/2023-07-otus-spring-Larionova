package spring11.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import spring11.domain.Author;
import spring11.domain.Book;
import spring11.domain.Genre;
import spring11.dto.BookDto;
import spring11.mapper.BookMapper;
import spring11.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final BookMapper mapper;

    private final AuthorService authorService;

    private final GenreService genreService;

    @Override
    public Flux<BookDto> getAll() {
        return repository.findAll().publishOn(Schedulers.boundedElastic())
                .map(mapper::map);
    }

    @Override
    public Mono<BookDto> getBookById(Long id) {
        return repository.findById(id).map(mapper::map);
    }

    @Override
    public Mono<Book> getBookDomainById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<BookDto> saveBook(BookDto bookDto) {
        return getBook(bookDto)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(repository::save)
                .map(mapper::map);
    }

    @Override
    public Mono<BookDto> updateBook(BookDto bookDto) {
        return getBook(bookDto).publishOn(Schedulers.boundedElastic())
                .flatMap(repository::save).map(mapper::map);
    }

    @Override
    public Mono<Void> deleteBookById(Long id) {
        return repository.deleteById(id);
    }

    private Mono<Book> getBook(BookDto bookDto) {
        return Mono.zip(
                        Mono.just(bookDto),
                        authorService.getAuthorByName(bookDto.getAuthor()),
                        genreService.getGenreByName(bookDto.getGenre())
                )
                .flatMap(data -> {
                    Author author = data.getT2();
                    Genre genre = data.getT3();
                    var book = new Book(bookDto.getId(), data.getT1().getName(), author, genre);
                    return Mono.just(book);
                });
    }
}
