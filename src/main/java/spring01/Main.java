package spring01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring01.loader.CsvParser;
import spring01.loader.QuestionParser;
import spring01.model.Question;
import spring01.service.QuizService;
import spring01.test.TestService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (AbstractApplicationContext context =
                     new ClassPathXmlApplicationContext("/spring-context.xml")) {
            QuestionParser questionParser = context.getBean(CsvParser.class);
            List<Question> questions = questionParser.getQuestions();
            QuizService quizService = context.getBean(QuizService.class);
            quizService.printQuiz(questions);
            TestService service = context.getBean(TestService.class);
            service.runTest();
        }
    }
}
