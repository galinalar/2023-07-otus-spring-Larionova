package spring01.loader;

import java.util.List;
import java.util.Map;

public interface QuestionParser {
    Map<String, List<String[]>> getQuestions();
}