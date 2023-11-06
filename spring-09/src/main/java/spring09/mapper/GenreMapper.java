package spring09.mapper;

import org.mapstruct.Mapper;
import spring09.domain.Genre;
import spring09.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
