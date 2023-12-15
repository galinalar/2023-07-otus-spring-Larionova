package spring11.mapper;

import org.mapstruct.Mapper;
import spring11.domain.Author;
import spring11.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
