package spring08.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring08.domain.Author;
import spring08.domain.Book;
import spring08.domain.Comment;
import spring08.domain.Genre;
import spring08.dto.CommentDto;
import spring08.mapper.BookMapperImpl;
import spring08.mapper.CommentMapperImpl;
import spring08.repository.BookRepository;
import spring08.repository.CommentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {BookServiceImpl.class, CommentServiceImpl.class, CommentMapperImpl.class, BookMapperImpl.class})
class CommentServiceImplTest {
    @MockBean
    private CommentRepository repository;

    @MockBean
    private BookRepository repositoryBook;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GenreService genreService;

    @Autowired
    private CommentService service;

    Author author = new Author(1L, "Unknown");
    Genre genre = new Genre(2L, "Horr");
    Book book = new Book(1L, "Dracula", author, genre, null);
    Comment comment = new Comment(1L, "not good", book);
    CommentDto commentDto = new CommentDto(1L, "not good", 1L);

    @Test
    void getCommentById() {
        when(repository.findById(1L)).thenReturn(java.util.Optional.ofNullable(comment));
        CommentDto comment = service.getCommentById(1L);
        assertEquals(commentDto, comment);
    }

    @Test
    void getByBookId() {
        when(repository.findByBookId(1L)).thenReturn(List.of(comment));
        List<CommentDto> commentDtos = service.getByBookId(1L);
        assertEquals(List.of(commentDto), commentDtos);
    }
}