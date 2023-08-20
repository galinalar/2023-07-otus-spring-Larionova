package spring01.service;

import spring01.model.Question;

import java.util.List;

public class QuizServiceImpl implements QuizService {
    private QuestionServiceImpl questionService;

    public QuizServiceImpl(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @Override
    public void createAndPrintQuiz() {
        printQuiz(createQuiz());
    }

    @Override
    public List<Question> createQuiz() {
        return questionService.getQuestions();
    }

    @Override
    public void printQuiz(List<Question> questions) {
        for (Question question: questions) {
            questionService.printQuestion(question);
        }
    }

}
