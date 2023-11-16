package spring10.mapper;

import org.mapstruct.Mapper;
import spring10.domain.Genre;
import spring10.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
