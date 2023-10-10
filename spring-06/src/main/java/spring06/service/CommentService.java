package spring06.service;

import spring06.domain.Comment;
import spring06.dto.CommentDto;

public interface CommentService {
    CommentDto getCommentById(Long id);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(Long id);
}
