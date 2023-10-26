package spring08.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring08.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, Long> {
}
