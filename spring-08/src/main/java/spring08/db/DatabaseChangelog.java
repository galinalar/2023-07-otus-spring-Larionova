package spring08.db;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import spring08.domain.Author;
import spring08.domain.Book;
import spring08.domain.Comment;
import spring08.domain.Genre;

import java.util.List;

@ChangeLog
public class DatabaseChangelog {
    private Author readyAuthor1;

    private Author readyAuthor2;

    private Author readyAuthor3;

    private Genre readyGenre1;

    private Genre readyGenre2;

    private Genre readyGenre3;

    private Book readyBook;

    @ChangeSet(order = "001", id = "authors", author = "larionova")
    public void addAuthors(MongockTemplate mongoTemplate) {
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
    public void addGenres(MongockTemplate mongoTemplate) {
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
    public void addBooks(MongockTemplate mongoTemplate) {
        Book book = new Book();
        book.setName("Dracula");
        book.setAuthor(readyAuthor2);
        book.setGenre(readyGenre3);
        book.setId(1L);
        readyBook = mongoTemplate.save(book);
    }

    @ChangeSet(order = "004", id = "comments", author = "larionova")
    public void addComments(MongockTemplate mongoTemplate) {
        Comment comment = new Comment();
        comment.setText("good");
        comment.setBook(readyBook);
        comment.setId(1L);

        mongoTemplate.save(comment);

        readyBook.setComments(List.of(comment));

        mongoTemplate.save(readyBook);
    }
}
