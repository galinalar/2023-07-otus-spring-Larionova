package spring09.mapper;

import org.mapstruct.Mapper;
import spring09.domain.Author;
import spring09.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
