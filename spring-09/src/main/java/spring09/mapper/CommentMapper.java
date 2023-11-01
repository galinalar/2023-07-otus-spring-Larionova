package spring09.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring09.domain.Comment;
import spring09.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
