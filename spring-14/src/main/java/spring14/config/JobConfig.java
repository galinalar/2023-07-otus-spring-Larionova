package spring14.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import spring14.domain.h2.Author;
import spring14.domain.h2.Book;
import spring14.domain.h2.Genre;
import spring14.domain.mongo.AuthorMongo;
import spring14.domain.mongo.BookMongo;
import spring14.domain.mongo.GenreMongo;
import spring14.service.DataConverterService;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class JobConfig {

    public static final String IMPORT_JOB_NAME = "importJob";

    private static final int CHUNK_SIZE = 5;

    private final MongoTemplate mongoTemplate;

    private final DataSource dataSource;

    private final DataConverterService dataConverterService;

    private final Logger logger = LoggerFactory.getLogger("Batch");

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Bean
    public Job importLibraryJob() {
        return new JobBuilder(IMPORT_JOB_NAME, jobRepository)
                .incrementer(new RunIdIncrementer())
                .flow(authorStep())
                .next(genreStep())
                .next(bookStep())
                .end()
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(@NonNull JobExecution jobExecution) {
                        logger.info("Начало job");
                    }

                    @Override
                    public void afterJob(@NonNull JobExecution jobExecution) {
                        logger.info("Конец job");
                    }
                })
                .build();
    }

    @Bean
    public Step bookStep() {
        return new StepBuilder("bookStep", jobRepository)
                .<BookMongo, Book>chunk(CHUNK_SIZE, platformTransactionManager)
                .reader(bookReader())
                .processor(bookItemProcessor())
                .writer(bookWriter())
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Book> bookWriter() {
        return new JdbcBatchItemWriterBuilder<Book>()
                .dataSource(dataSource)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("insert into books (name, author_id, genre_id) values " +
                        "(:name, :author.id, :genre.id)")
                .build();
    }

    @Bean
    public ItemProcessor<BookMongo, Book> bookItemProcessor() {
        return dataConverterService::transform;
    }

    @Bean
    public MongoItemReader<BookMongo> bookReader() {
        return new MongoItemReaderBuilder<BookMongo>()
                .name("bookReader")
                .targetType(BookMongo.class)
                .template(mongoTemplate)
                .jsonQuery("{}")
                .sorts(Map.of())
                .build();
    }

    @Bean
    public Step authorStep() {
        return new StepBuilder("authorStep", jobRepository)
                .<AuthorMongo, Author>chunk(CHUNK_SIZE, platformTransactionManager)
                .reader(authorReader())
                .processor(authorItemProcessor())
                .writer(authorWriter())
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Author> authorWriter() {
        return new JdbcBatchItemWriterBuilder<Author>()
                .dataSource(dataSource)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("insert into authors (name) values (:name)")
                .build();
    }

    @Bean
    public ItemProcessor<AuthorMongo, Author> authorItemProcessor() {
        return dataConverterService::transform;
    }

    @Bean
    public MongoItemReader<AuthorMongo> authorReader() {
        return new MongoItemReaderBuilder<AuthorMongo>()
                .name("authorReader")
                .targetType(AuthorMongo.class)
                .template(mongoTemplate)
                .jsonQuery("{}")
                .sorts(Map.of())
                .build();
    }

    @Bean
    public Step genreStep() {
        return new StepBuilder("genreStep", jobRepository)
                .<GenreMongo, Genre>chunk(CHUNK_SIZE, platformTransactionManager)
                .reader(genreReader())
                .processor(genreItemProcessor())
                .writer(genreWriter())
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Genre> genreWriter() {
        return new JdbcBatchItemWriterBuilder<Genre>()
                .dataSource(dataSource)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("insert into genres (name) values (:name)")
                .build();
    }

    @Bean
    public ItemProcessor<GenreMongo, Genre> genreItemProcessor() {
        return dataConverterService::transform;
    }

    @Bean
    public MongoItemReader<GenreMongo> genreReader() {
        return new MongoItemReaderBuilder<GenreMongo>()
                .name("genreReader")
                .targetType(GenreMongo.class)
                .template(mongoTemplate)
                .jsonQuery("{}")
                .sorts(Map.of())
                .build();
    }
}
