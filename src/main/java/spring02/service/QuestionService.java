package spring02.service;

import spring02.model.Question;

import java.util.List;

public interface QuestionService {
    void printQuestion(Question question);

    List<Question> getQuestions();
}
