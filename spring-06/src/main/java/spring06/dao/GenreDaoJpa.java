package spring06.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring06.domain.Genre;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GenreDaoJpa implements GenreDao {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = entityManager.createQuery("select g from Genre g ", Genre.class);
        return query.getResultList();
    }

    @Override
    public Genre getById(Long id) {
        return entityManager.find(Genre.class, id);
    }
}
