package spring02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring02.loader.CsvParser;
import spring02.mapper.QuestionMapperImpl;
import spring02.model.Question;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionMapperImpl questionMapper;

    private CsvParser csvParser;

    @Autowired
    public QuestionServiceImpl(QuestionMapperImpl questionMapper, CsvParser csvParser) {
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
