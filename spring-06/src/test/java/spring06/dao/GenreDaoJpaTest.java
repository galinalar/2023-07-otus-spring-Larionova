package spring06.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import spring06.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(GenreDaoJpa.class)
class GenreDaoJpaTest {

    @Autowired
    private GenreDaoJpa dao;

    Genre expected1 = new Genre(1L, "Unknown");
    Genre expected2 = new Genre(2L, "Horr");
    Genre expected3 = new Genre(3L, "Fan");

    @Test
    void getAll() {
        List<Genre> genreList = dao.getAll();
        assertThat(genreList).containsExactlyInAnyOrder(expected1, expected2, expected3);
    }

    @Test
    void getById() {
        Genre get = dao.getById(2L);
        assertEquals(expected2, get);
    }
}