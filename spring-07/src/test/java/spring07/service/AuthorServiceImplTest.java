package spring07.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring07.domain.Author;
import spring07.dto.AuthorDto;
import spring07.mapper.AuthorMapper;
import spring07.mapper.AuthorMapperImpl;
import spring07.repository.AuthorRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        Author author = service.geAuthorById(2L);
        assertEquals(expectedAuthor2, author);
    }
}