package spring06.dao;

import spring06.domain.Book;
import spring06.domain.Comment;

import java.util.List;

public interface BookDao {
    void insert(Book book);

    Book getById(long id);

    List<Book> getAll();

    void deleteById(Book book);

    void update(Book book);

    List<Comment> getCommentsByBook(Long id);
}
