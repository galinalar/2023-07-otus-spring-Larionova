package spring09.repository;

import org.springframework.data.repository.CrudRepository;
import spring09.domain.Comment;

import java.util.List;


public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByBookId(Long id);

}
