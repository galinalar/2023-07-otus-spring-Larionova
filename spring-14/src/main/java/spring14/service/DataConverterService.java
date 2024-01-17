package spring14.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring14.domain.h2.Author;
import spring14.domain.h2.Book;
import spring14.domain.h2.Genre;
import spring14.domain.mongo.AuthorMongo;
import spring14.domain.mongo.BookMongo;
import spring14.domain.mongo.GenreMongo;
import spring14.repository.AuthorRepository;
import spring14.repository.GenreRepository;

@Service
@RequiredArgsConstructor
public class DataConverterService {

    private final AuthorRepository authorRepository;

    private final GenreRepository genreRepository;

    public Book transform(BookMongo book) {
        return new Book(null,book.getName(), authorRepository.findByName(book.getAuthorMongo().getName()),
                genreRepository.findByName(book.getGenreMongo().getName()));
    }

    public Author transform(AuthorMongo author) {
        return new Author(null, author.getName());
    }

    public Genre transform(GenreMongo genre) {
        return new Genre(null, genre.getName());
    }
}
