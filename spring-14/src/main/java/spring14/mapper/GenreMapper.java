package spring14.mapper;

import org.mapstruct.Mapper;
import spring14.domain.h2.Genre;
import spring14.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
