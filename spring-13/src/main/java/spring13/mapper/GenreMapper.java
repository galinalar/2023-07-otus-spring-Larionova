package spring13.mapper;

import org.mapstruct.Mapper;
import spring13.domain.Genre;
import spring13.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
