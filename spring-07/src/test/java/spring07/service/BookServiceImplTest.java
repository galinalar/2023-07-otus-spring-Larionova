package spring07.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring07.domain.Author;
import spring07.domain.Book;
import spring07.domain.Genre;
import spring07.dto.AuthorDto;
import spring07.dto.BookDto;
import spring07.dto.GenreDto;
import spring07.mapper.AuthorMapperImpl;
import spring07.mapper.BookMapperImpl;
import spring07.mapper.GenreMapperImpl;
import spring07.repository.BookRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {BookServiceImpl.class, AuthorMapperImpl.class, GenreMapperImpl.class, BookMapperImpl.class})
class BookServiceImplTest {
    @MockBean
    private BookRepository repository;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GenreService genreService;

    @Autowired
    private BookService service;

    Author author = new Author(1L, "Unknown");
    Genre genre = new Genre(2L, "Horr");
    AuthorDto authorDto = new AuthorDto(1L, "Unknown");
    GenreDto genreDto = new GenreDto(2L, "Horr");

    Book expected1 = new Book(1L, "Dracula", author, genre, null);
    Book expectedNull1 = new Book(null, "Dracula", author, genre, null);
    BookDto expectedDto1 = new BookDto(1L, "Dracula", authorDto, genreDto);
    BookDto expectedDtoNull1 = new BookDto(null, "Dracula", authorDto, genreDto);

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(List.of(expected1));
        List<BookDto> books = service.getAll();
        assertEquals(List.of(expectedDto1), books);
    }

    @Test
    void getBookById() {
        when(repository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expected1));
        BookDto book = service.getBookById(1L);
        assertEquals(expectedDto1, book);
    }

    @Test
    void saveBook() {
        when(authorService.geAuthorById(any())).thenReturn(author);
        when(genreService.geGenreById(any())).thenReturn(genre);

        service.saveBook("Dracula", 1L, 2L);

        verify(repository, times(1)).save(eq(expectedNull1));
    }

    @Test
    void updateBook() {
        when(authorService.geAuthorById(any())).thenReturn(author);
        when(genreService.geGenreById(any())).thenReturn(genre);

        service.saveBook("Dracula", 1L, 2L);
        service.updateBook(1L, "Dracula", 1L, 2L);

        verify(repository, times(1)).save(eq(expected1));
    }
}