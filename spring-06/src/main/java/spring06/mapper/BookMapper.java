package spring06.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring06.domain.Book;
import spring06.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", source = "book.id")
    @Mapping(target = "name", source = "book.name")
    BookDto map(Book book);
}
