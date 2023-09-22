package spring04.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@RequiredArgsConstructor
@ShellComponent
public class QuizCommands {
    private final ApplicationRunner applicationRunner;

    @ShellMethod(value = "start", key = {"-st", "--start"})
    public void startTest() throws Exception {
        applicationRunner.run(null);
    }

    @ShellMethod(value = "exit", key = {"-ext", "--exit"})
    public void exit() {
        System.exit(0);
    }
}
