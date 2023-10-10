package spring06.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import spring06.domain.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(AuthorDaoJpa.class)
public class AuthorDaoJpaTest {
    @Autowired
    private AuthorDaoJpa dao;

    Author expectedAuthor1 = new Author(1L, "Unknown");
    Author expectedAuthor2 = new Author(2L, "Stoker");
    Author expectedAuthor3 = new Author(3L, "King");

    @Test
    void getAll() {
        List<Author> authorsList = dao.getAll();
        assertThat(authorsList).containsExactlyInAnyOrder(expectedAuthor1, expectedAuthor2, expectedAuthor3);
    }

    @Test
    void getById() {
        Author author = dao.getById(2L);
        assertEquals(expectedAuthor2, author);
    }
}