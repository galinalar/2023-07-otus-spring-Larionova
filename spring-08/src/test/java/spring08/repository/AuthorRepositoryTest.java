package spring08.repository;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import spring08.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class AuthorRepositoryTest {

    @Autowired
    MongoTemplate mongoTemplate;

    Author expectedAuthor1 = new Author(1L, "Unknown");
    Author expectedAuthor2 = new Author(2L, "Bram Stoker");
    Author expectedAuthor3 = new Author(3L, "Stephen King");

    @Test
    void findById() {
        var get = mongoTemplate.findById(1L, Author.class);

        assertEquals(expectedAuthor1, get);
    }

    @Test
    void findAll() {
        var result = mongoTemplate.findAll(Author.class);
        assertEquals(3, result.size());
        assertThat(result).containsExactlyInAnyOrder(expectedAuthor1, expectedAuthor2, expectedAuthor3);
    }
}