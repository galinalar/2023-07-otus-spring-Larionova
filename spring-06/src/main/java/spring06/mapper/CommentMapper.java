package spring06.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring06.domain.Comment;
import spring06.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
