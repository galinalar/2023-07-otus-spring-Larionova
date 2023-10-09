package spring05.mapper;

import org.mapstruct.Mapper;
import spring05.domain.Genre;
import spring05.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
