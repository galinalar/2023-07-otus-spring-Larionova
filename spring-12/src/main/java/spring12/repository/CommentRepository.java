package spring12.repository;

import org.springframework.data.repository.CrudRepository;
import spring12.domain.Comment;

import java.util.List;


public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByBookId(Long id);

}
