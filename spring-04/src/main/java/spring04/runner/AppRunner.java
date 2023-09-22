package spring04.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring04.service.QuizService;

@Component
@Primary
public class AppRunner implements ApplicationRunner {
    private final QuizService quizService;

    @Autowired
    public AppRunner(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        quizService.startQuiz();
    }
}
