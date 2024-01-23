package spring14.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring14.domain.h2.Book;
import spring14.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", source = "book.id")
    @Mapping(target = "name", source = "book.name")
    BookDto map(Book book);
}
