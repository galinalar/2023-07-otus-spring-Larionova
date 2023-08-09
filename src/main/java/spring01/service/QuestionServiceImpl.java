package spring01.service;

import spring01.loader.CsvParser;
import spring01.mapper.QuestionMapper;
import spring01.model.Option;
import spring01.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        return convertMapToList(loadQuestions());
    }

    public Map<String, List<String[]>> loadQuestions() {
        return csvParser.getQuestions();
    }

    private List<Question> convertMapToList(Map<String, List<String[]>> mapQuestionAndOptions) {
        List<Question> questions = new ArrayList<>();
        for (String questionText: mapQuestionAndOptions.keySet()) {
            List<String[]> options = mapQuestionAndOptions.get(questionText);
            int id = questions.size() + 1;
            Question question = createQuestion(questionText, options, id);
            questions.add(question);
        }
        return questions;
    }

    private Question createQuestion(String questionText, List<String[]> options, int id) {
        Question question = new Question(questionText);
        for (String[] option: options) {
            if (option[1].equals("true")) {
                question.setAnswer(option[0]);
            }
            Option optionData = new Option(option[0]);
            question.addOption(optionData);
            question.setId(id);
        }
        return question;
    }
}
