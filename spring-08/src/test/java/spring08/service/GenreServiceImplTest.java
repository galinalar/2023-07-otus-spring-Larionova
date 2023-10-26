package spring08.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring08.domain.Genre;
import spring08.dto.GenreDto;
import spring08.mapper.GenreMapper;
import spring08.mapper.GenreMapperImpl;
import spring08.repository.GenreRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {GenreServiceImpl.class, GenreMapperImpl.class})
class GenreServiceImplTest {

    @MockBean
    private GenreRepository repository;

    @Autowired
    private GenreMapper mapper;

    @Autowired
    private GenreService service;

    Genre expected1 = new Genre(1L, "Unknown");
    Genre expected2 = new Genre(2L, "Horr");
    Genre expected3 = new Genre(3L, "Fan");

    GenreDto expectedDto1 = new GenreDto(1L, "Unknown");
    GenreDto expectedDto2 = new GenreDto(2L, "Horr");
    GenreDto expectedDto3 = new GenreDto(3L, "Fan");

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(List.of(expected1, expected2, expected3));

        List<GenreDto> genreDtos = service.getAll();

        assertEquals(List.of(expectedDto1, expectedDto2, expectedDto3), genreDtos);
    }

    @Test
    void geGenreById() {
        when(repository.findById(2L)).thenReturn(java.util.Optional.ofNullable(expected2));
        Genre genre = service.getGenreById(2L);
        assertEquals(expected2, genre);
    }
}