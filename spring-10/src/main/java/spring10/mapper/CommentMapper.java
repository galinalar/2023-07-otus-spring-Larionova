package spring10.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring10.domain.Comment;
import spring10.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
