package spring02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import spring02.model.Option;
import spring02.model.Question;
import spring02.model.Result;
import spring02.service.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizServiceImplTestWithMock {

    QuestionServiceImpl questionService = Mockito.mock(QuestionServiceImpl.class);
    QuizService quizService;
    IOService ioService;

    @BeforeAll
    public void setUp() {
        ioService = new IOServiceImpl();
        quizService = new QuizServiceImpl(questionService, ioService, 1, 3);
    }

    @Test
    public void createQuizTest(){
        when(questionService.getQuestions()).thenReturn(getQuestion());
        List<Question> questions = quizService.createQuiz();
        assertEquals(3, questions.size());
    }

    @Test
    public void checkQuizPassedTest(){
        assertEquals(Result.PASSED, quizService.checkQuiz(getQuestion(), getStudentAnswerPassed()));
    }

    @Test
    public void checkQuizFailedTest(){
        assertEquals(Result.FAILED, quizService.checkQuiz(getQuestion(), getStudentAnswerFailed()));
    }

    private List<Option> getStudentAnswerPassed(){
        return List.of(new Option("11"), new Option("Russia"), new Option("3"));
    }
    private List<Option> getStudentAnswerFailed(){
        return List.of(new Option("3"), new Option("11"), new Option("Russia"));
    }

    private List<Question> getQuestion() {
        Question question1 = new Question("How many months have more than 29 days?");
        question1.addOption(new Option("1"));
        question1.addOption(new Option("11"));
        question1.addOption(new Option("12"));
        question1.setAnswer("11");
        Question question2 = new Question("Which country is the largest in the world?");
        question2.addOption(new Option("Russia"));
        question2.addOption(new Option("China"));
        question2.addOption(new Option("USA"));
        question2.addOption(new Option("India"));
        question2.setAnswer("Russia");
        Question question3 = new Question("2+2/2=?");
        question3.addOption(new Option("2"));
        question3.addOption(new Option("3"));
        question3.setAnswer("3");

        return List.of(question1, question2, question3);
    }
}
