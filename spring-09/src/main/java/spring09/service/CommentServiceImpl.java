package spring09.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring09.domain.Comment;
import spring09.dto.CommentDto;
import spring09.mapper.CommentMapper;
import spring09.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    private final CommentMapper commentMapper;

    @Override
    public CommentDto getCommentById(Long id) {
        return commentMapper.map(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void saveComment(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        Comment comment =  repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(comment);
    }

    @Override
    @Transactional
    public List<CommentDto> getByBookId(Long id) {
        return repository.findByBookId(id).stream()
                .map(commentMapper::map).toList();
    }
}
