package spring01.service;

import spring01.mapper.QuestionMapper;
import spring01.model.Question;

import java.util.List;

public class QuizServiceImpl implements QuizService {
    private QuestionMapper questionMapper;

    public QuizServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public void printQuiz(List<Question> questions) {
        for (Question question: questions) {
            System.out.println(questionMapper.questionToString(question));
        }
    }
}
