package spring14.service;

import spring14.domain.h2.Author;
import spring14.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author getAuthorById(Long id);
}
