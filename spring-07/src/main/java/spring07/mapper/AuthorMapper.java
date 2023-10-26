package spring07.mapper;

import org.mapstruct.Mapper;
import spring07.domain.Author;
import spring07.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
