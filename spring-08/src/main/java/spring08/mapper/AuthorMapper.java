package spring08.mapper;

import org.mapstruct.Mapper;
import spring08.domain.Author;
import spring08.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
