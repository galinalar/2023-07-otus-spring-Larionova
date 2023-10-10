package spring06.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring06.domain.Comment;

@RequiredArgsConstructor
@Component
public class CommentDaoJpa implements CommentDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Comment getById(Long id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public void insert(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void update(Comment comment) {
        entityManager.merge(comment);
    }

    @Override
    public void delete(Comment comment) {
        entityManager.remove(comment);
    }

}
