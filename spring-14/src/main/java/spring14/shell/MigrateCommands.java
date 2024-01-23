package spring14.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@RequiredArgsConstructor
@ShellComponent
public class MigrateCommands {
    private final JobLauncher jobLauncher;

    private final Job importLibraryJob;

    @ShellMethod(value = "startMigrationMongoDbToH2", key = "start")
    public void startMigrationJobWithJobOperator() throws Exception {
        JobExecution execution = jobLauncher.run(importLibraryJob, new JobParametersBuilder()
                .toJobParameters());
        System.out.println(execution);
    }
}
