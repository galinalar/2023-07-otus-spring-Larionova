package spring03.mapper;

import spring03.model.Question;

import java.util.List;

public interface QuestionMapper {
    String questionToString(Question question);

    List<Question> getQuestionList(List<String[]> lines);

}
