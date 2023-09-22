package spring04.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring04.service.LocaleProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvParser implements QuizParser {

    private static final String DELIMITER = ";";

    private static final String FILE_NAME_PATTERN = "{0}_{1}.csv";

    private LocaleProvider localeProvider;

    private final String resourceName;

    @Autowired
    public CsvParser(@Value("${resource-file}") String resourceName, LocaleProvider localeProvider) {
        this.localeProvider = localeProvider;
        this.resourceName = MessageFormat.format(FILE_NAME_PATTERN, resourceName, localeProvider.getCurrent());
    }

    @Override
    public List<String[]> getQuizList() {
        return parseCsvToListOfString();
    }

    private  List<String[]> parseCsvToListOfString() {
        List<String[]> lines = new ArrayList<>();
        try (InputStream srcStream =
                     getClass().getClassLoader().getResourceAsStream(resourceName);
             BufferedReader br = new BufferedReader(new InputStreamReader(srcStream))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) {
                    first = false;
                } else {
                    String[] values = line.split(DELIMITER);
                    lines.add(values);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

}
