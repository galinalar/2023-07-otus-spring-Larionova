package spring1718.mapper;

import org.mapstruct.Mapper;
import spring1718.domain.Genre;
import spring1718.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
