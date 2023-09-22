package spring04.service;

import spring04.model.Option;
import spring04.model.Question;
import spring04.model.Result;
import spring04.model.StudentQuiz;

import java.util.List;

public interface QuizService {

    List<Question> createQuiz();

    void printQuiz(List<Question> questions);

    StudentQuiz startQuiz();

    Result checkQuiz(List<Question> questions, List<Option> studentAnswers);
}
