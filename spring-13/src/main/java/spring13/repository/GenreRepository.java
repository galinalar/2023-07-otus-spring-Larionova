package spring13.repository;

import org.springframework.data.repository.CrudRepository;
import spring13.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre getGenreByName(String name);
}
