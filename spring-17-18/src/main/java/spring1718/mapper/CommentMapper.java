package spring1718.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring1718.domain.Comment;
import spring1718.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
