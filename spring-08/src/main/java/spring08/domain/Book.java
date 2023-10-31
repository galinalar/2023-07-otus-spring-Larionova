package spring08.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection =  "books")
public class Book {
    @Id
    private Long id;

    private String name;

    @DBRef
    private Author author;

    @DBRef
    private Genre genre;

    @DBRef
    private List<Comment> comments;
}
