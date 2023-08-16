package spring02.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring02.loader.CsvParser;
import spring02.mapper.QuestionMapper;
import spring02.service.QuestionServiceImpl;
import spring02.service.QuizServiceImpl;

@Configuration
@PropertySource("classpath:spring02/application.properties")
public class BeanConfig {
    @Bean
    public CsvParser csvParser(@Value("${resource-file}") String resourceName) {
        return new CsvParser(resourceName);
    }

    @Bean
    public QuestionMapper questionMapper() {
        return new QuestionMapper();
    }

    @Bean
    public QuestionServiceImpl questionService(QuestionMapper questionMapper, CsvParser csvParser) {
        return new QuestionServiceImpl(questionMapper, csvParser);
    }

    @Bean
    public QuizServiceImpl quizServiceImpl(QuestionServiceImpl questionService,
                                       @Value("${pass-condition}") int passCondition,
                                       @Value("${count-question}") int questionCounter) {
        return new QuizServiceImpl(questionService, passCondition, questionCounter, System.in);
    }
}