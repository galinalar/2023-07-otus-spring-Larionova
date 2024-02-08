package spring1718.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring1718.domain.Author;
import spring1718.domain.Book;
import spring1718.domain.Genre;
import spring1718.dto.BookDto;
import spring1718.mapper.BookMapper;
import spring1718.repository.BookRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final BookMapper mapper;

    private final AuthorService authorService;

    private final GenreService genreService;

    @Override
    @CircuitBreaker(name = "books", fallbackMethod = "bookAll")
    public List<BookDto> getAll() throws InterruptedException {
        Thread.sleep(2000);
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::map).toList();
    }

    public List<BookDto> bookAll(Throwable throwable) {
        return Collections.singletonList(new BookDto());
    }

    @Override
    @CircuitBreaker(name = "books", fallbackMethod = "book")
    public BookDto getBookById(Long id) {
        return mapper.map(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    public BookDto book(Throwable throwable) {
        return new BookDto();
    }

    @Override
    public Book getBookDomainById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void saveBook(String name, String authorN, String genreN) {
        Author author = authorService.getAuthorByName(authorN);
        Genre genre = genreService.getGenreByName(genreN);
        Book book = new Book(null, name, author, genre, null);
        repository.save(book);
    }

    @Override
    public void updateBook(Long id, String name, String authorN, String genreN) {
        Author author = authorService.getAuthorByName(authorN);
        Genre genre = genreService.getGenreByName(genreN);
        Book book = new Book(id, name, author, genre, null);
        repository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(book);
    }

}
