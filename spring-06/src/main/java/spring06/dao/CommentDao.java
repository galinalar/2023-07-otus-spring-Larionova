package spring06.dao;

import spring06.domain.Comment;

import java.util.List;

public interface CommentDao {

    Comment getById(Long id);

    void insert(Comment comment);

    void update(Comment comment);

    void delete(Comment comment);

    List<Comment> getByBookId(Long id);

    List<Comment> getComByBookId(Long id);
}
