package spring01.mapper;

import spring01.model.Option;
import spring01.model.Question;

import java.util.List;

public class QuestionMapper {
    public String questionToString(Question question) {
        StringBuilder str = new StringBuilder("Question: " + question.getQuestion() + "\n" + "Options: ");
        List<Option> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            Option option = options.get(i);
            str.append("\n").append(i + 1).append(". ").append(option.getOption());
        }
        return str.toString();
    }
}
