package spring09.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring09.domain.Author;
import spring09.domain.Book;
import spring09.domain.Genre;
import spring09.dto.BookDto;
import spring09.mapper.BookMapper;
import spring09.repository.BookRepository;

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
    public List<BookDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::map).toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        return mapper.map(repository.findById(id).orElseThrow(RuntimeException::new));
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
