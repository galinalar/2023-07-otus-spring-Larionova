package spring05.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import spring05.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(GenreDaoJdbc.class)
public class GenreDaoJdbcTest {
    @Autowired
    private GenreDaoJdbc dao;
    @Test
    void getAll() {
        Genre expected1 = new Genre(1L, "Unknown");
        Genre expected2 = new Genre(2L, "Horr");
        Genre expected3 = new Genre(3L, "Fan");

        List<Genre> genreList = dao.getAll();

        assertThat(genreList).containsExactlyInAnyOrder(expected1, expected2, expected3);
    }
}
