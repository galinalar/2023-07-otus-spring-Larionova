package spring07.service;

import spring07.domain.Comment;
import spring07.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto getCommentById(Long id);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(Long id);

    List<CommentDto> getByBookId(Long id);
}
