package spring04;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

@SpringBootTest(properties = "spring.shell.interactive.enabled=false")
public class Main04Test {
    private static final String FIRST_NAME = "firstName\n";
    private static final String LAST_NAME = "lastName\n";
    private static final String USER_ANSWER1 = "3\n";
    private static final String USER_ANSWER2 = "11\n";
    private static final String USER_ANSWER3 = "2\n";

    @BeforeAll
    public static void setUp() {
        System.setIn(new ByteArrayInputStream(getUserTestInput().getBytes()));
    }

    @AfterAll
    public static void end() {
        System.setIn(System.in);
    }

    @Test
    void contextLoads() {}

    private static String getUserTestInput() {
        return String.join(FIRST_NAME,
                LAST_NAME,
                USER_ANSWER1,
                USER_ANSWER2,
                USER_ANSWER3,
                USER_ANSWER3,
                USER_ANSWER3);
    }
}
