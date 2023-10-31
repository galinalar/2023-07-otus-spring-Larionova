package spring08.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring08.domain.Author;
import spring08.dto.AuthorDto;
import spring08.mapper.AuthorMapper;
import spring08.mapper.AuthorMapperImpl;
import spring08.repository.AuthorRepository;
import spring08.service.AuthorServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {AuthorServiceImpl.class, AuthorMapperImpl.class})
@ExtendWith({SpringExtension.class})
class AuthorServiceImplTest {
    @MockBean
    private AuthorRepository repository;

    @Autowired
    private AuthorMapper mapper;

    @Autowired
    private AuthorService service;

    Author expectedAuthor1 = new Author(1L, "Unknown");
    Author expectedAuthor2 = new Author(2L, "Stoker");
    Author expectedAuthor3 = new Author(3L, "King");

    AuthorDto expectedAuthorDto1 = new AuthorDto(1L, "Unknown");
    AuthorDto expectedAuthorDto2 = new AuthorDto(2L, "Stoker");
    AuthorDto expectedAuthorDto3 = new AuthorDto(3L, "King");

    List<Author> authors = List.of(expectedAuthor1, expectedAuthor2, expectedAuthor3);
    List<AuthorDto> authorsDto = List.of(expectedAuthorDto1, expectedAuthorDto2, expectedAuthorDto3);

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(authors);
        List<AuthorDto> authorDtos = service.getAll();
        assertEquals(authorsDto, authorDtos);

    }

    @Test
    void geAuthorById() {
        when(repository.findById(2L)).thenReturn(java.util.Optional.ofNullable(expectedAuthor2));
        Author author = service.getAuthorById(2L);
        assertEquals(expectedAuthor2, author);
    }
}