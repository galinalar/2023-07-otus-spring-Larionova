package spring14.repository;

import org.springframework.data.repository.CrudRepository;
import spring14.domain.h2.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByName(String name);
}
