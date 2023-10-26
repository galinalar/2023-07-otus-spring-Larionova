package spring08.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring08.domain.Author;
import spring08.domain.Book;
import spring08.domain.Genre;
import spring08.dto.BookDto;
import spring08.mapper.BookMapper;
import spring08.repository.BookRepository;

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
    public void saveBook(Long id, String name, Long authorId, Long genreId) {
        Author author = authorService.getAuthorById(authorId);
        Genre genre = genreService.getGenreById(genreId);
        Book book = new Book(id, name, author, genre, null);
        repository.save(book);
    }

    @Override
    public void updateBook(Long id, String name, Long authorId, Long genreId) {
        Author author = authorService.getAuthorById(authorId);
        Genre genre = genreService.getGenreById(genreId);
        Book book = new Book(id, name, author, genre, null);
        repository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(book);
    }

}
