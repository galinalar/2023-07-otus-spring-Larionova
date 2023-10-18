package spring07.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring07.domain.Author;
import spring07.domain.Book;
import spring07.domain.Genre;
import spring07.dto.BookDto;
import spring07.mapper.BookMapper;
import spring07.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final BookMapper mapper;

    private final AuthorService authorService;

    private final GenreService genreService;

    @Override
    public List<BookDto> getAll() {
        return repository.findAll().stream()
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
    @Transactional
    public void saveBook(String name, Long authorId, Long genreId) {
        Author author = authorService.geAuthorById(authorId);
        Genre genre = genreService.geGenreById(genreId);
        Book book = new Book(null, name, author, genre, null);
        repository.save(book);
    }

    @Override
    @Transactional
    public void updateBook(Long id, String name, Long authorId, Long genreId) {
        Author author = authorService.geAuthorById(authorId);
        Genre genre = genreService.geGenreById(genreId);
        Book book = new Book(id, name, author, genre, null);
        repository.save(book);
    }

    @Override
    @Transactional
    public void deleteBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(book);
    }

}
