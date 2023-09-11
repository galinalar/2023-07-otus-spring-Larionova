package spring02.mapper;

import spring02.model.Question;

import java.util.List;

public interface QuestionMapper {
    String questionToString(Question question);

    List<Question> getQuestionList(List<String[]> lines);

}
