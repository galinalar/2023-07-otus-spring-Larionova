package spring13.mapper;

import org.mapstruct.Mapper;
import spring13.domain.Author;
import spring13.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
