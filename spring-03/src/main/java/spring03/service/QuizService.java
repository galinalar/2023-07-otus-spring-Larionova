package spring03.service;

import spring03.model.Option;
import spring03.model.Question;
import spring03.model.Result;
import spring03.model.StudentQuiz;

import java.util.List;

public interface QuizService {
    void createAndPrintQuiz();

    List<Question> createQuiz();

    void printQuiz(List<Question> questions);

    StudentQuiz startQuiz();

    Result checkQuiz(List<Question> questions, List<Option> studentAnswers);
}
