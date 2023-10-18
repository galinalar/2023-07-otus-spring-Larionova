package spring06.service;

import spring06.domain.Author;
import spring06.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author geAuthorById(Long id);
}
