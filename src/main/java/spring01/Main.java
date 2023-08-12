package spring01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring01.service.QuizService;
import spring01.test.TestService;

public class Main {
    public static void main(String[] args) {
        try (AbstractApplicationContext context =
                     new ClassPathXmlApplicationContext("/spring-context.xml")) {
            QuizService quizService = context.getBean(QuizService.class);
            quizService.createAndPrintQuiz();

            TestService service = context.getBean(TestService.class);
            service.runTest();
        }
    }
}
