package spring11.mapper;

import org.mapstruct.Mapper;
import spring11.domain.Genre;
import spring11.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
