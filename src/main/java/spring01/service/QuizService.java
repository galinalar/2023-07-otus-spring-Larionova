package spring01.service;

import spring01.model.Question;

import java.util.List;

public interface QuizService {
    void printQuiz(List<Question> questions);
}
