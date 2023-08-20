package spring02.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvParser implements QuizParser {

    private static final String DELIMITER = ";";

    private final String resourceName;

    @Autowired
    public CsvParser(String resourceName) {
        this.resourceName = resourceName;
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
