package spring03.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import spring03.model.Option;
import spring03.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizServiceImplTest {

    @Autowired
    QuizService quizService;

    @Test
    void parseTest() {
        List<Question> questions =  quizService.createQuiz();
        List<Question> questionsExp = getExpected();
        for (int i = 0; i < 5; i++){
            assertEquals(questionsExp.get(i).getQuestion(), questions.get(i).getQuestion());
            assertEquals(questionsExp.get(i).getAnswer(), questions.get(i).getAnswer());
            assertEquals(questionsExp.get(i).getOptions().size(), questions.get(i).getOptions().size());
            List<Option> exp = questionsExp.get(i).getOptions();
            List<Option> act = questions.get(i).getOptions();
            for (int j = 0; j < questionsExp.get(i).getOptions().size(); j++){
                assertEquals(exp.get(j).getOption(), act.get(j).getOption());
            }

        }
    }


    private List<Question> getExpected() {
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
        Question question4 = new Question("One of the Java frameworks...");
        question4.addOption(new Option("Winter"));
        question4.addOption(new Option("Spring"));
        question4.addOption(new Option("Summer"));
        question4.addOption(new Option("Autumn"));
        question4.setAnswer("Spring");
        Question question5 = new Question("How many t are in the word letter?");
        question5.addOption(new Option("1"));
        question5.addOption(new Option("2"));
        question5.setAnswer("2");

        return List.of(question3, question1, question4, question5, question2);
    }
}
