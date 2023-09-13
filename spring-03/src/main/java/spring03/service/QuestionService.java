package spring03.service;

import spring03.model.Question;

import java.util.List;

public interface QuestionService {
    void printQuestion(Question question);

    List<Question> getQuestions();
}
