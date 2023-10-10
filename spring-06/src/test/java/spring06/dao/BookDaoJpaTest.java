package spring06.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import spring06.domain.Author;
import spring06.domain.Book;
import spring06.domain.Comment;
import spring06.domain.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Import(BookDaoJpa.class)
class BookDaoJpaTest {
    @Autowired
    private BookDaoJpa dao;

    Author author = new Author(1L, "Unknown");
    Genre genre = new Genre(2L, "Horr");
    Author author2 = new Author(2L, "Stoker");
    Genre genre2 = new Genre(3L, "Fan");
    Book expected1 = new Book(1L, "Dracula", author, genre, null);

    @Test
    void insertAndGetIdAndDelete() {
        Book inserted = new Book(null, "test", author2, genre2, null);

        List<Book> bookList = dao.getAll();
        dao.insert(inserted);
        Book get = dao.getById(2L);

        assertEquals(inserted.getAuthor(), get.getAuthor());
        assertEquals(inserted.getGenre(), get.getGenre());
        assertEquals(inserted, get);

        int sizeBeforeDelete = dao.getAll().size();
        dao.deleteById(inserted);
        int sizeAfterDelete = dao.getAll().size();

        assertEquals(sizeBeforeDelete-1, sizeAfterDelete);
    }

    @Test
    void getAll() {
        List<Book> bookList = dao.getAll();

        assertEquals(1, bookList.size());
        assertEquals(expected1.getAuthor().getName(), bookList.get(0).getAuthor().getName());
        assertEquals(expected1.getGenre().getName(), bookList.get(0).getGenre().getName());
        assertEquals(expected1.getName(), bookList.get(0).getName());
        assertEquals(expected1.getId(), bookList.get(0).getId());
    }

    @Test
    void update() {
        Book updated = new Book(1L, "testUp", author2, genre2, null);
        dao.update(updated);

        Book get = dao.getById(1L);

        assertEquals(updated.getAuthor(), get.getAuthor());
        assertEquals(updated.getGenre(), get.getGenre());
        assertEquals(updated.getName(), get.getName());
        assertEquals(updated.getId(), get.getId());
    }

    @Test
    void getCommentsByBook() {
        Comment comment = new Comment(1L, "not good", expected1);
        List<Comment> get = dao.getCommentsByBook(1L);

        assertEquals(1, get.size());
        assertEquals(comment.getText(), get.get(0).getText());
        assertEquals(comment.getBook().getId(), get.get(0).getBook().getId());
        assertEquals(comment.getId(), get.get(0).getId());
    }
}