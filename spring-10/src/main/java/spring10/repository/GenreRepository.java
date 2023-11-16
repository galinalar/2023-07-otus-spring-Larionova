package spring10.repository;

import org.springframework.data.repository.CrudRepository;
import spring10.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre getGenreByName(String name);
}
