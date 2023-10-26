package spring08.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring08.domain.Comment;

import java.util.List;


public interface CommentRepository extends MongoRepository<Comment, Long> {
    List<Comment> findByBookId(Long id);

}
