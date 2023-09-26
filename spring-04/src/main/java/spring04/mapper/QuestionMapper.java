package spring04.mapper;

import spring04.model.Question;

import java.util.List;

public interface QuestionMapper {
    String questionToString(Question question);

    List<Question> getQuestionList(List<String[]> lines);

}
