package spring01.service;

import spring01.loader.CsvParser;
import spring01.mapper.QuestionMapper;
import spring01.model.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private QuestionMapper questionMapper;

    private CsvParser csvParser;

    public QuestionServiceImpl(QuestionMapper questionMapper,  CsvParser csvParser) {
        this.questionMapper = questionMapper;
        this.csvParser = csvParser;
    }

    @Override
    public void printQuestion(Question question) {
        System.out.println(questionMapper.questionToString(question));
    }

    @Override
    public List<Question> getQuestions() {
        return questionMapper.getQuestionList(csvParser.getQuizList());
    }

}
