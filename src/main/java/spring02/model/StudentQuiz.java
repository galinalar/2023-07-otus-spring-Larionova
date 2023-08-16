package spring02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class StudentQuiz {
    private Student student;

    private List<Option> answers;

    private Enum<Result> resultEnum;
}
