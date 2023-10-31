package spring08.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@RequiredArgsConstructor
@ShellComponent
public class ExitCommands {
    @ShellMethod(value = "exiting", key = {"e", "exit"})
    public void exit() {
        System.exit(0);
    }
}
