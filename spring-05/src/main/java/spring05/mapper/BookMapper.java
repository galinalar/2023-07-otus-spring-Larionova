package spring05.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring05.domain.Book;
import spring05.dto.AuthorDto;
import spring05.dto.BookDto;
import spring05.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", source = "book.id")
    @Mapping(target = "name", source = "book.name")
    BookDto map(Book book, AuthorDto author, GenreDto genre);
}
