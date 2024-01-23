package spring14.db;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import spring14.domain.mongo.AuthorMongo;
import spring14.domain.mongo.BookMongo;
import spring14.domain.mongo.GenreMongo;

@ChangeLog
public class DatabaseChangelog {
    private AuthorMongo readyAuthor1Mongo;

    private AuthorMongo readyAuthor2Mongo;

    private AuthorMongo readyAuthor3Mongo;

    private GenreMongo readyGenre1Mongo;

    private GenreMongo readyGenre2Mongo;

    private GenreMongo readyGenre3Mongo;

    private BookMongo readyBookMongo;

    @ChangeSet(order = "001", id = "authors", author = "larionova")
    public void addAuthors(MongockTemplate mongoTemplate) {
        AuthorMongo authorMongo1 = new AuthorMongo();
        authorMongo1.setName("Unknown");
        authorMongo1.setId(1L);
        readyAuthor1Mongo = mongoTemplate.save(authorMongo1);

        AuthorMongo authorMongo2 = new AuthorMongo();
        authorMongo2.setName("Bram Stoker");
        authorMongo2.setId(2L);
        readyAuthor2Mongo = mongoTemplate.save(authorMongo2);

        AuthorMongo authorMongo3 = new AuthorMongo();
        authorMongo3.setName("Stephen King");
        authorMongo3.setId(3L);
        readyAuthor3Mongo = mongoTemplate.save(authorMongo3);
    }

    @ChangeSet(order = "002", id = "genres", author = "larionova")
    public void addGenres(MongockTemplate mongoTemplate) {
        GenreMongo genreMongo1 = new GenreMongo();
        genreMongo1.setName("Unknown");
        genreMongo1.setId(1L);
        readyGenre1Mongo = mongoTemplate.save(genreMongo1);

        GenreMongo genreMongo2 = new GenreMongo();
        genreMongo2.setName("Horror");
        genreMongo2.setId(2L);
        readyGenre2Mongo = mongoTemplate.save(genreMongo2);

        GenreMongo genreMongo3 = new GenreMongo();
        genreMongo3.setName("Fantasy");
        genreMongo3.setId(3L);
        readyGenre3Mongo = mongoTemplate.save(genreMongo3);
    }

    @ChangeSet(order = "003", id = "books", author = "larionova")
    public void addBooks(MongockTemplate mongoTemplate) {
        BookMongo bookMongo = new BookMongo();
        bookMongo.setName("Dracula");
        bookMongo.setAuthorMongo(readyAuthor2Mongo);
        bookMongo.setGenreMongo(readyGenre3Mongo);
        bookMongo.setId(1L);
        readyBookMongo = mongoTemplate.save(bookMongo);
    }
}
