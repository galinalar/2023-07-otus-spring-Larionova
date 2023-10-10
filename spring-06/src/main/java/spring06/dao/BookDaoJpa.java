package spring06.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring06.domain.Book;
import spring06.domain.Comment;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BookDaoJpa implements BookDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void insert(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book getById(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b ", Book.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Book book) {
        entityManager.remove(book);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public List<Comment> getCommentsByBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book.getComments();
    }
}
