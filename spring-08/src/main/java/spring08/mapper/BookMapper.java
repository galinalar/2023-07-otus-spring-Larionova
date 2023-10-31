package spring08.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring08.domain.Book;
import spring08.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", source = "book.id")
    @Mapping(target = "name", source = "book.name")
    BookDto map(Book book);
}
