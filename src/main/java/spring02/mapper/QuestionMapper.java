package spring02.mapper;

import org.springframework.stereotype.Component;
import spring02.model.Option;
import spring02.model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QuestionMapper {
    public String questionToString(Question question) {
        StringBuilder str = new StringBuilder("Question " + question.getID() + ": " + question.getQuestion()
                + "\n" + "Options: ");
        List<Option> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            Option option = options.get(i);
            str.append("\n").append(i + 1).append(". ").append(option.getOption());
        }
        return str.toString();
    }

    public List<Question> getQuestionList(List<String[]> lines) {
        Map<String, List<String[]>> mapQuestionAndOptions = parseArrToMap(lines);
        return convertMapToList(mapQuestionAndOptions);
    }

    private Map<String, List<String[]>> parseArrToMap(List<String[]> lines) {
        Map<String, List<String[]>> mapQuestionAndOptions = new HashMap<>();
        for (String[] values: lines) {
            mapQuestionAndOptions.put(values[0], addOption(values, mapQuestionAndOptions));
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

    private List<Question> convertMapToList(Map<String, List<String[]>> mapQuestionAndOptions) {
        List<Question> questions = new ArrayList<>();
        for (String questionText: mapQuestionAndOptions.keySet()) {
            List<String[]> options = mapQuestionAndOptions.get(questionText);
            int id = questions.size() + 1;
            Question question = createQuestion(questionText, options, id);
            questions.add(question);
        }
        return questions;
    }

    private Question createQuestion(String questionText, List<String[]> options, int id) {
        Question question = new Question(questionText);
        for (String[] option: options) {
            if (option[1].equals("true")) {
                question.setAnswer(option[0]);
            }
            Option optionData = new Option(option[0]);
            question.addOption(optionData);
            question.setId(id);
        }
        return question;
    }
}
