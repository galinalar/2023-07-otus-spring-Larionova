package spring08.mapper;

import org.mapstruct.Mapper;
import spring08.domain.Genre;
import spring08.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
