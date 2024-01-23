package spring14.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection =  "books")
public class BookMongo {
    @Id
    private Long id;

    private String name;

    @DBRef
    private AuthorMongo authorMongo;

    @DBRef
    private GenreMongo genreMongo;
}
