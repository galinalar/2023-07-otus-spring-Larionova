package spring13.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring13.domain.Comment;
import spring13.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
