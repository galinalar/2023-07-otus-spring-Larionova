package spring03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring03.model.Option;
import spring03.model.Question;
import spring03.model.Result;
import spring03.model.Student;
import spring03.model.StudentQuiz;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    public static final String INPUT_NAME_MESSAGE = "input.name.message";

    public static final String INPUT_LAST_NAME_MESSAGE = "input.last.name.message";

    public static final String INPUT_ANSWER = "input.answer";

    private QuestionService questionService;

    private IOService ioService;

    private LocalizationService localizationService;

    private final int passCondition;

    private final int questionCounter;

    @Autowired
    public QuizServiceImpl(QuestionService questionService, IOService ioService,
                           LocalizationService localizationService, @Value("${pass-condition}") int passCondition,
                           @Value("${count-question}") int questionCounter) {
        this.questionService = questionService;
        this.passCondition = passCondition;
        this.questionCounter = questionCounter;
        this.ioService = ioService;
        this.localizationService = localizationService;
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

    @Override
    public StudentQuiz startQuiz() {
        List<Question> questions = createQuiz();
        printQuiz(questions);
        Student student = createStudent();
        List<Option> answers = writeAnswers();
        Result result = checkQuiz(questions, answers);
        System.out.println(localizationService.getMessage(result.toString()));
        return new StudentQuiz(student, answers, result);
    }

    @Override
    public Result checkQuiz(List<Question> questions, List<Option> studentAnswers) {
        int right = 0;
        for (int i = 0; i < questionCounter; i++) {
            if (questions.get(i).getAnswer().equals(studentAnswers.get(i).getOption())) {
                right++;
            }
        }
        if (right >= passCondition) {
            return Result.PASSED;
        } else {
            return Result.FAILED;
        }
    }

    private Student createStudent() {
        System.out.println(localizationService.getMessage(INPUT_NAME_MESSAGE));
        String name = ioService.readString();
        System.out.println(localizationService.getMessage(INPUT_LAST_NAME_MESSAGE));
        String lastName = ioService.readString();
        return new Student(name, lastName);
    }

    private List<Option> writeAnswers() {
        List<Option> answers = new ArrayList<>();
        for (int i = 1; i <= questionCounter; i++) {
            System.out.println(localizationService.getMessage(INPUT_ANSWER, i));
            answers.add(new Option(ioService.readString()));
        }
        return answers;
    }
}
