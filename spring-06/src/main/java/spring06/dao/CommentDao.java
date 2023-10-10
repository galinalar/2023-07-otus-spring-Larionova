package spring06.dao;

import spring06.domain.Comment;

public interface CommentDao {

    Comment getById(Long id);

    void insert(Comment comment);

    void update(Comment comment);

    void delete(Comment comment);
}
