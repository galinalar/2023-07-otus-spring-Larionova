package spring1718.repository;

import org.springframework.data.repository.CrudRepository;
import spring1718.domain.Comment;

import java.util.List;


public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByBookId(Long id);

}
