package spring12.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring12.domain.Book;
import spring12.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", source = "book.id")
    @Mapping(target = "name", source = "book.name")
    @Mapping(target = "author", source = "author.name")
    @Mapping(target = "genre", source = "genre.name")
    BookDto map(Book book);
}
