package spring02.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private final String question;

    private int id;

    private String answer;

    private List<Option> options;

    public Question(String question) {
        this.question = question;
        this.options = new ArrayList<>();
    }


    public String getQuestion() {
        return question;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(Option option) {
        options.add(option);
    }
}
