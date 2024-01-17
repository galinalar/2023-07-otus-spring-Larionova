package spring14.mapper;

import org.mapstruct.Mapper;
import spring14.domain.h2.Author;
import spring14.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
