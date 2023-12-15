package spring11.db;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Mono;
import spring11.domain.Author;
import spring11.domain.Book;
import spring11.domain.Genre;

@ChangeLog
public class DatabaseChangelog {
    private Mono<Author> readyAuthor1;

    private Mono<Author> readyAuthor2;

    private Mono<Author> readyAuthor3;

    private Mono<Genre> readyGenre1;

    private Mono<Genre> readyGenre2;

    private Mono<Genre> readyGenre3;

    private Mono<Book> readyBook;

    @ChangeSet(order = "001", id = "authors", author = "larionova")
    public void addAuthors(ReactiveMongoOperations mongoTemplate) {
        Author author1 = new Author();
        author1.setName("Unknown");
        author1.setId(1L);
        readyAuthor1 = mongoTemplate.save(author1);

        Author author2 = new Author();
        author2.setName("Bram Stoker");
        author2.setId(2L);
        readyAuthor2 = mongoTemplate.save(author2);

        Author author3 = new Author();
        author3.setName("Stephen King");
        author3.setId(3L);
        readyAuthor3 = mongoTemplate.save(author3);
    }

    @ChangeSet(order = "002", id = "genres", author = "larionova")
    public void addGenres(ReactiveMongoOperations mongoTemplate) {
        Genre genre1 = new Genre();
        genre1.setName("Unknown");
        genre1.setId(1L);
        readyGenre1 = mongoTemplate.save(genre1);

        Genre genre2 = new Genre();
        genre2.setName("Horror");
        genre2.setId(2L);
        readyGenre2 = mongoTemplate.save(genre2);

        Genre genre3 = new Genre();
        genre3.setName("Fantasy");
        genre3.setId(3L);
        readyGenre3 = mongoTemplate.save(genre3);
    }

    @ChangeSet(order = "003", id = "books", author = "larionova")
    public void addBooks(ReactiveMongoOperations mongoTemplate) {
        Author author2 = new Author();
        author2.setName("Bram Stoker");
        author2.setId(2L);
        Genre genre3 = new Genre();
        genre3.setName("Fantasy");
        genre3.setId(3L);
        Book book = new Book();
        book.setName("Dracula");
        book.setAuthor(author2);
        book.setGenre(genre3);
        book.setId(1L);
        readyBook = mongoTemplate.save(book);
    }

}
