package spring12.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring12.domain.Comment;
import spring12.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
