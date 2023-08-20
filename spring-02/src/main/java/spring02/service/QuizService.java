package spring02.service;

import spring02.model.Option;
import spring02.model.Question;
import spring02.model.Result;
import spring02.model.StudentQuiz;

import java.util.List;

public interface QuizService {
    void createAndPrintQuiz();

    List<Question> createQuiz();

    void printQuiz(List<Question> questions);

    StudentQuiz startQuiz();

    Result checkQuiz(List<Question> questions, List<Option> studentAnswers);
}
