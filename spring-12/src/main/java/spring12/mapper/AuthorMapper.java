package spring12.mapper;

import org.mapstruct.Mapper;
import spring12.domain.Author;
import spring12.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
