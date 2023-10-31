package spring08.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring08.domain.Author;
import spring08.domain.Book;
import spring08.domain.Genre;
import spring08.dto.AuthorDto;
import spring08.dto.BookDto;
import spring08.dto.GenreDto;
import spring08.mapper.AuthorMapperImpl;
import spring08.mapper.BookMapperImpl;
import spring08.mapper.GenreMapperImpl;
import spring08.repository.BookRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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
        when(authorService.getAuthorById(any())).thenReturn(author);
        when(genreService.getGenreById(any())).thenReturn(genre);

        service.saveBook(1L, "Dracula", 1L, 2L);

        ArgumentCaptor<Book> captor = ArgumentCaptor.forClass(Book.class);
        verify(repository).save(captor.capture());
        assertTrue(captor.getValue().getName().equals(expectedNull1.getName()));
        assertTrue(captor.getValue().getAuthor().equals(author));
        assertTrue(captor.getValue().getGenre().equals(genre));
    }

    @Test
    void updateBook() {
        when(authorService.getAuthorById(any())).thenReturn(author);
        when(genreService.getGenreById(any())).thenReturn(genre);

        service.saveBook(1L, "Dracula", 1L, 2L);
        service.updateBook(1L, "Dracula2", 1L, 2L);

        ArgumentCaptor<Book> captor = ArgumentCaptor.forClass(Book.class);
        verify(repository, times(2)).save(captor.capture());
        assertTrue(captor.getValue().getName().equals("Dracula2"));
        assertTrue(captor.getValue().getAuthor().equals(author));
        assertTrue(captor.getValue().getGenre().equals(genre));
    }
}