package spring02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import spring02.service.QuizService;

@ComponentScan
@PropertySource("classpath:spring02/application.properties")
public class Main02 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(Main02.class)) {
            QuizService quizService = context.getBean(QuizService.class);
            quizService.startQuiz();
        }
    }
}
