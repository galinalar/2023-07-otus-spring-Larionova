package spring02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring02.model.Option;
import spring02.model.Question;
import spring02.model.Result;
import spring02.model.Student;
import spring02.model.StudentQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuizServiceImpl implements QuizService {
    private QuestionServiceImpl questionService;

    private final int passCondition;

    private final int questionCounter;

    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public QuizServiceImpl(QuestionServiceImpl questionService,
                           int passCondition, int questionCounter) {
        this.questionService = questionService;
        this.passCondition = passCondition;
        this.questionCounter = questionCounter;
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
        System.out.println(result);
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
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input last name: ");
        String lastName = scanner.nextLine();
        return new Student(name, lastName);
    }

    private List<Option> writeAnswers() {
        List<Option> answers = new ArrayList<>();
        for (int i = 1; i <= questionCounter; i++) {
            System.out.println("Input answer to " + i + " question: ");
            answers.add(new Option(scanner.nextLine()));
        }
        return answers;
    }
}
