package spring05.mapper;

import org.mapstruct.Mapper;
import spring05.domain.Author;
import spring05.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
