package spring06.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring06.dao.CommentDao;
import spring06.domain.Comment;
import spring06.dto.CommentDto;
import spring06.mapper.CommentMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    private final CommentMapper commentMapper;

    @Override
    public CommentDto getCommentById(Long id) {
        return commentMapper.map(commentDao.getById(id));
    }

    @Override
    @Transactional
    public void saveComment(Comment comment) {
        commentDao.insert(comment);
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        commentDao.update(comment);
    }

    @Override
    @Transactional
    public void deleteCommentById(Long id) {
        Comment comment = commentDao.getById(id);
        commentDao.delete(comment);
    }

    @Override
    @Transactional
    public List<CommentDto> getByBookId(Long id) {
        return commentDao.getByBookId(id).stream()
                .map(commentMapper::map).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentDto> getComByBookId(Long id) {
        return commentDao.getComByBookId(id).stream()
                .map(commentMapper::map).toList();
    }
}
