package spring11;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class Main11 {
    public static void main(String[] args) {
        SpringApplication.run(Main11.class, args);
    }
}