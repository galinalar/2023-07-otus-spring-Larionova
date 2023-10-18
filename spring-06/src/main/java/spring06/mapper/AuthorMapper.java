package spring06.mapper;

import org.mapstruct.Mapper;
import spring06.domain.Author;
import spring06.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
