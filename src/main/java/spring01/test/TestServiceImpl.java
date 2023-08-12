package spring01.test;

import org.springframework.util.Assert;
import spring01.mapper.QuestionMapper;
import spring01.model.Question;
import spring01.service.QuestionService;

import java.util.List;


public class TestServiceImpl implements TestService {
    private QuestionService questionService;

    private QuestionMapper questionMapper;

    public TestServiceImpl(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @Override
    public void runTest() {
        List<Question> questions = questionService.getQuestions();
        Assert.state(questions.size() == 5, "Service malfunction");
        String questionString = questionMapper.questionToString(questions.get(0));
        boolean stringEquals = questionString.equals("Question 1: 2+2/2=?\n" +
                "Options: \n" +
                "1. 2\n" +
                "2. 3");
        Assert.state(stringEquals, "Mapper is not working correctly");
    }
}
