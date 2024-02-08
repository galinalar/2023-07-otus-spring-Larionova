package spring1718.repository;

import org.springframework.data.repository.CrudRepository;
import spring1718.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre getGenreByName(String name);
}
