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

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({CommentDaoJpa.class, BookDaoJpa.class})
class CommentDaoJpaTest {
    @Autowired
    private CommentDaoJpa dao;
    @Autowired
    private BookDaoJpa daoBook;

    Author author = new Author(1L, "Unknown");
    Genre genre = new Genre(2L, "Horr");
    Book book = new Book(1L, "Dracula", author, genre, null);
    Comment comment = new Comment(1L, "not good", book);
    @Test
    void getById() {
        Comment get = dao.getById(1L);

        assertEquals(comment.getBook().getId(), get.getBook().getId());
        assertEquals(comment.getText(), get.getText());
    }
    @Test
    void  getByBookId() {
        List<Comment> get = dao.getByBookId(1L);

        assertEquals(1, get.size());
        assertEquals(comment.getText(), get.get(0).getText());
        assertEquals(comment.getId(), get.get(0).getId());
    }

    @Test
    void insert() {
        Comment inserted = new Comment(null, "best", book);
        dao.insert(inserted);

        Comment get = dao.getById(2L);
        assertEquals(inserted.getText(), get.getText());
    }

    @Test
    void update() {
        Comment updated = new Comment(1L, "good", book);
        dao.update(updated);

        Comment get = dao.getById(1L);
        assertEquals(updated.getBook().getId(), get.getBook().getId());
        assertEquals(updated.getText(), get.getText());
    }

//    @Test
//    void delete() {
//        Comment insert = new Comment(null, "best", book);
//        Comment inserted = new Comment(2L, "best", book);
//        dao.insert(insert);
//        int sizeBeforeDelete = daoBook.getCommentsByBook(1L).size();
//        dao.delete(dao.getById(2L));
//        int sizeAfterDelete = daoBook.getCommentsByBook(1L).size();
//
//        assertEquals(sizeBeforeDelete-1, sizeAfterDelete);
//    }
}