package spring04.service;

import spring04.model.Question;

import java.util.List;

public interface QuestionService {
    void printQuestion(Question question);

    List<Question> getQuestions();
}
