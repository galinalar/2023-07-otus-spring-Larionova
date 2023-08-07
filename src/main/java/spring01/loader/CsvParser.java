package spring01.loader;

import spring01.model.Option;
import spring01.model.Question;

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
    public List<Question> getQuestions() {
        return parseCsvToMap();
    }

    private  List<Question> parseCsvToMap() {
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
        return parseMapToList(mapQuestionAndOptions);
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

    private List<Question> parseMapToList(Map<String, List<String[]>> mapQuestionAndOptions) {
        List<Question> questions = new ArrayList<>();
        for (String questionText: mapQuestionAndOptions.keySet()) {
            List<String[]> options = mapQuestionAndOptions.get(questionText);
            Question question = createQuestion(questionText, options);
            questions.add(question);
        }
        return questions;
    }

    private Question createQuestion(String questionText, List<String[]> options) {
        Question question = new Question(questionText);
        for (String[] option: options) {
            if (option[1].equals("true")) {
                question.setAnswer(option[0]);
            }
            Option optionData = new Option(option[0]);
            question.addOption(optionData);
        }
        return question;
    }
}
