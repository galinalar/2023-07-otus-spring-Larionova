package spring07.mapper;

import org.mapstruct.Mapper;
import spring07.domain.Genre;
import spring07.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
