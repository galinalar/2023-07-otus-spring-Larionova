package spring01.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvParser implements QuestionParser {

    private static final String DELIMITER = ";";

    private final String resourceName;

    public CsvParser(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public Map<String, List<String[]>> getQuestions() {
        return parseCsvToMap();
    }

    private  Map<String, List<String[]>> parseCsvToMap() {
        Map<String, List<String[]>> mapQuestionAndOptions = new HashMap<>();
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
                    mapQuestionAndOptions.put(values[0], addOption(values, mapQuestionAndOptions));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return mapQuestionAndOptions;
    }

    private List<String[]> addOption(String[] values, Map<String, List<String[]>> mapQuestionAndOptions) {
        String[] newOption = {values[1], values[2]};
        List<String[]> options;
        if (mapQuestionAndOptions.containsKey(values[0])) {
            options = mapQuestionAndOptions.get(values[0]);
        } else {
            options = new ArrayList<>();
        }
        options.add(newOption);
        return options;
    }
}
