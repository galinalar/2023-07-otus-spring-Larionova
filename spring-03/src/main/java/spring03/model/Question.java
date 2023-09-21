package spring03.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Question {

    private final String question;

    private int id;

    private String answer;

    private List<Option> options = new ArrayList<>();

    public void addOption(Option option) {
        options.add(option);
    }
}
