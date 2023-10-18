package spring06.mapper;

import org.mapstruct.Mapper;
import spring06.domain.Genre;
import spring06.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
