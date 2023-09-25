package spring04.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import spring04.service.QuizService;

@RequiredArgsConstructor
@ShellComponent
public class QuizCommands {
    private final QuizService quizService;

    @ShellMethod(value = "start", key = {"-st", "--start"})
    public void startTest() throws Exception {
        quizService.startQuiz();
    }

    @ShellMethod(value = "exit", key = {"-ext", "--exit"})
    public void exit() {
        System.exit(0);
    }
}
