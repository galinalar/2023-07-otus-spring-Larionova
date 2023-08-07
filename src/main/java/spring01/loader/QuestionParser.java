package spring01.loader;

import spring01.model.Question;

import java.util.List;

public interface QuestionParser {
    List<Question> getQuestions();
}