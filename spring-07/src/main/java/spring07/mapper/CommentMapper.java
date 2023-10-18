package spring07.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring07.domain.Comment;
import spring07.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
