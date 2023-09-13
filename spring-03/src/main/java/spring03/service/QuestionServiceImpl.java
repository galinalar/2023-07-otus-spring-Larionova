package spring03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring03.loader.CsvParser;
import spring03.mapper.QuestionMapper;
import spring03.model.Question;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionMapper questionMapper;

    private CsvParser csvParser;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper, CsvParser csvParser) {
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
