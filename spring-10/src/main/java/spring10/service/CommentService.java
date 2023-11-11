package spring10.service;

import spring10.domain.Comment;
import spring10.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto getCommentById(Long id);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(Long id);

    List<CommentDto> getByBookId(Long id);
}
