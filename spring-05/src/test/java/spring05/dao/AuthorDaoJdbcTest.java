package spring05.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import spring05.domain.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(AuthorDaoJdbc.class)
public class AuthorDaoJdbcTest {
    @Autowired
    private AuthorDaoJdbc dao;
    @Test
    void getAll() {
        Author expectedAuthor1 = new Author(1L, "Unknown");
        Author expectedAuthor2 = new Author(2L, "Stoker");
        Author expectedAuthor3 = new Author(3L, "King");

        List<Author> authorsList = dao.getAll();

        assertThat(authorsList).containsExactlyInAnyOrder(expectedAuthor1, expectedAuthor2, expectedAuthor3);
    }
}
