package spring1718.mapper;

import org.mapstruct.Mapper;
import spring1718.domain.Author;
import spring1718.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
