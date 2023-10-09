package spring05.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import spring05.domain.Book;
import spring05.dto.AuthorDto;
import spring05.dto.BookDto;
import spring05.dto.GenreDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(BookDaoJdbc.class)
public class BookDaoJdbcTest {
    @Autowired
    private BookDaoJdbc dao;

    AuthorDto author = new AuthorDto(1L, "Unknown");
    GenreDto genre = new GenreDto(2L, "Horr");
    BookDto expected1 = new BookDto(1L, "Dracula", author, genre);

    @Test
    void getAll() {
        List<BookDto> bookList = dao.getAll();

        assertEquals(1, bookList.size());
        assertEquals(expected1.getAuthor().getName(), bookList.get(0).getAuthor().getName());
        assertEquals(expected1.getGenre().getName(), bookList.get(0).getGenre().getName());
        assertEquals(expected1.getName(), bookList.get(0).getName());
        assertEquals(expected1.getId(), bookList.get(0).getId());
    }

    @Test
    void insertAndGetId() {
        Book inserted = new Book(null, "test", 2L, 3L);

        AuthorDto author = new AuthorDto(2L, "Stoker");
        GenreDto genre = new GenreDto(3L, "Fan");
        BookDto expectedInsert = new BookDto(2L, "test", author, genre);

        List<BookDto> bookList = dao.getAll();
        dao.insert(inserted);
        BookDto get = dao.getById(2L);

        assertEquals(expectedInsert.getAuthor().getName(), get.getAuthor().getName());
        assertEquals(expectedInsert.getGenre().getName(), get.getGenre().getName());
        assertEquals(expectedInsert.getName(), get.getName());
        assertEquals(expectedInsert.getId(), get.getId());
    }


    @Test
    void delete() {
        int sizeBeforeDelete = dao.getAll().size();
        dao.deleteById(1L);
        int sizeAfterDelete = dao.getAll().size();

        assertEquals(sizeBeforeDelete-1, sizeAfterDelete);
    }


    @Test
    void update() {
        Book updated = new Book(1L, "testUp", 2L, 3L);
        dao.update(updated);

        AuthorDto author = new AuthorDto(2L, "Stoker");
        GenreDto genre = new GenreDto(3L, "Fan");
        BookDto expectedUpdate = new BookDto(1L, "testUp", author, genre);

        BookDto get = dao.getById(1L);

        assertEquals(expectedUpdate.getAuthor().getName(), get.getAuthor().getName());
        assertEquals(expectedUpdate.getGenre().getName(), get.getGenre().getName());
        assertEquals(expectedUpdate.getName(), get.getName());
        assertEquals(expectedUpdate.getId(), get.getId());
    }
}
