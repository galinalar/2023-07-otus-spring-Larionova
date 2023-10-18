package spring06.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import spring06.domain.Book;
import spring06.domain.Comment;

import java.util.List;

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

    @Override
    public List<Comment> getByBookId(Long id) {
        Session session = (Session)entityManager.unwrap(Session.class);
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<Comment> critQuery = criteria.createQuery(Comment.class);

        Root<Comment> root = critQuery.from(Comment.class);
        critQuery.select(root).where(criteria.equal(root.get("book"), id));
        Query<Comment> query = session.createQuery(critQuery);
        List<Comment> results = query.getResultList();
        session.close();
        return results;
    }

    @Override
    public List<Comment> getComByBookId(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book.getComments();
    }

}
