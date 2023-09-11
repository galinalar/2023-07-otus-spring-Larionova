package spring01.service;

import spring01.model.Question;

import java.util.List;

public interface QuestionService {
    void printQuestion(Question question);

    List<Question> getQuestions();
}
