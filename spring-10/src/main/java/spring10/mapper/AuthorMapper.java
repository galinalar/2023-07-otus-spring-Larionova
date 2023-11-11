package spring10.mapper;

import org.mapstruct.Mapper;
import spring10.domain.Author;
import spring10.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
