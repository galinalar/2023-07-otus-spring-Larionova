package spring07.service;

import spring07.domain.Author;
import spring07.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author geAuthorById(Long id);
}
