package spring08.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring08.domain.Comment;
import spring08.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "bookId", source = "book.id")
    CommentDto map(Comment comment);
}
