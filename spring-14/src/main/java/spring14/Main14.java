package spring14;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongock
@EnableMongoRepositories
@EnableJpaRepositories
@SpringBootApplication
public class Main14 {
    public static void main(String[] args) {
        SpringApplication.run(Main14.class, args);
    }
}