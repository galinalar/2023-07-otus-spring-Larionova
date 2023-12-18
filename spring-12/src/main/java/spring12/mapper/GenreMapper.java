package spring12.mapper;

import org.mapstruct.Mapper;
import spring12.domain.Genre;
import spring12.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
