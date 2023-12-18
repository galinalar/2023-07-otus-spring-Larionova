package spring12.repository;

import org.springframework.data.repository.CrudRepository;
import spring12.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre getGenreByName(String name);
}
